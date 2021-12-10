package lyang.puml.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import lyang.puml.PumlConfiguration;
import lyang.puml.utils.Puml;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@Path("/gitlab")
public class GitLabResource {
  public static final String GH_API = "https://%s/api/v4/projects/%s/repository/files/";
  public static final String GITLAB = "gitlab.com";
  private final OkHttpClient client;
  private final ObjectMapper mapper;
  private final Map<String, String> hostMappings;

  @Inject
  public GitLabResource(OkHttpClient client, ObjectMapper mapper, PumlConfiguration configuration) {
    this.client = client;
    this.mapper = mapper;
    this.hostMappings = configuration.hostMappings;
  }

  @GET
  @Produces("image/png")
  @Path("/projects/{repo}/files/{commit}/{path:.+}")
  public Response get(
      @PathParam("repo") String repo,
      @PathParam("commit") String commit,
      @PathParam("path") String path,
      @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    Request request = getRequest(GITLAB, repo, commit, path);
    try (okhttp3.Response response = client.newCall(request).execute()) {
      return Puml.renderToResponse(getContent(response), pumlIndex).build();
    }
  }

  @GET
  @Produces("image/png")
  @Path("{host}/projects/{repo}/files/{commit}/{path:.+}")
  public Response get(
      @PathParam("host") String host,
      @PathParam("repo") String repo,
      @PathParam("commit") String commit,
      @PathParam("path") String path,
      @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    if (hostMappings.containsKey(host)) {
      Request request = getRequest(hostMappings.get(host), repo, commit, path);
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

  private Request getRequest(String host, String repo, String commit, String path) {
    HttpUrl.Builder builder =
        HttpUrl.parse(String.format(GH_API, host, repo))
            .newBuilder()
            .addPathSegment(path)
            .addQueryParameter("ref", commit);
    return new Request.Builder().url(builder.build()).build();
  }
}
