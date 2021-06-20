package lyang.puml.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import lyang.puml.utils.Puml;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Base64;

@Path("/github")
public class GitHubResource {
  public static final String GH_JSON = "application/vnd.github.v3+json";
  public static final String GH_API = "https://api.github.com/repos/%s/%s/contents/%s?ref=%s";
  private final OkHttpClient client;
  private final ObjectMapper mapper;

  @Inject
  public GitHubResource(OkHttpClient client, ObjectMapper mapper) {
    this.client = client;
    this.mapper = mapper;
  }

  @GET
  @Produces("image/png")
  @Path("/{owner}/{repo}/blob/{commit}/{path:.+}")
  public Response get(
      @PathParam("owner") String owner,
      @PathParam("repo") String repo,
      @PathParam("commit") String commit,
      @PathParam("path") String path,
      @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    Request request = getRequest(owner, repo, commit, path);
    try (okhttp3.Response response = client.newCall(request).execute()) {
      return Puml.renderToResponse(getContent(response), pumlIndex).build();
    }
  }

  private String getContent(okhttp3.Response response) throws IOException {
    String encoded = mapper.readTree(response.body().byteStream()).at("/content").asText();
    return new String(Base64.getDecoder().decode(encoded.replaceAll("\n", "")));
  }

  private Request getRequest(String owner, String repo, String commit, String path) {
    String url = String.format(GH_API, owner, repo, path, commit);
    return new Request.Builder().addHeader(HttpHeaders.ACCEPT, GH_JSON).url(url).build();
  }
}
