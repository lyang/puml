package lyang.puml.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import lyang.puml.PumlConfiguration;
import lyang.puml.utils.Puml;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@Path("/github")
public class GitHubResource {
  public static final String GH_API = "https://api.%s/repos/%s/%s/contents/%s?ref=%s";
  public static final String GH_JSON = "application/vnd.github.v3+json";
  public static final String GITHUB = "github.com";
  private final OkHttpClient client;
  private final ObjectMapper mapper;
  private final Map<String, String> hostMappings;

  @Inject
  public GitHubResource(OkHttpClient client, ObjectMapper mapper, PumlConfiguration configuration) {
    this.client = client;
    this.mapper = mapper;
    this.hostMappings = configuration.hostMappings;
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
    Request request = getRequest(GITHUB, owner, repo, commit, path);
    try (okhttp3.Response response = client.newCall(request).execute()) {
      return Puml.renderToResponse(getContent(response), pumlIndex).build();
    }
  }

  @GET
  @Produces("image/png")
  @Path("{host}/{owner}/{repo}/blob/{commit}/{path:.+}")
  public Response get(
          @PathParam("host") String host,
          @PathParam("owner") String owner,
          @PathParam("repo") String repo,
          @PathParam("commit") String commit,
          @PathParam("path") String path,
          @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
          throws IOException {
    if (hostMappings.containsKey(host)) {
      Request request = getRequest(hostMappings.get(host), owner, repo, commit, path);
      try (okhttp3.Response response = client.newCall(request).execute()) {
        return Puml.renderToResponse(getContent(response), pumlIndex).build();
      }
    } else {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

  private String getContent(okhttp3.Response response) throws IOException {
    String encoded = mapper.readTree(response.body().byteStream()).at("/content").asText();
    return new String(Base64.getDecoder().decode(encoded.replaceAll("\n", "")));
  }

  private Request getRequest(String host, String owner, String repo, String commit, String path) {
    String url = String.format(GH_API, host, owner, repo, path, commit);
    return new Request.Builder().addHeader(HttpHeaders.ACCEPT, GH_JSON).url(url).build();
  }
}
