package lyang.puml.resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

import net.sourceforge.plantuml.SourceStringReader;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import lyang.puml.configurations.GitHubConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/github")
public class GitHubResource {
  private static final String GITHUB_RAW_FORMAT = "application/vnd.github.v3.raw";
  private OkHttpClient client;
  private GitHubConfig config;

  @Inject
  public GitHubResource(OkHttpClient client, GitHubConfig config) {
    this.client = client;
    this.config = config;
  }

  @GET
  @Produces("image/png")
  @Path("/{target}/{user}/{repo}/{path:.+}")
  public Response get(@PathParam("target") String target,
                      @PathParam("user") String user,
                      @PathParam("repo") String repo,
                      @PathParam("path") String path) throws IOException {
    try (okhttp3.Response response = client.newCall(buildRequest(target, user, repo, path)).execute()) {
      return Response.ok(render(response.body().string())).build();
    }
  }

  private Request buildRequest(String target, String user, String repo, String path) {
    GitHubConfig.Config config = this.config.targets.get(target);
    String url = String.format("https://%s/repos/%s/%s/contents/%s", config.endpoint, user, repo, path);
    Request.Builder builder = new Request.Builder().addHeader(HttpHeaders.ACCEPT, GITHUB_RAW_FORMAT).url(url).get();
    Optional.ofNullable(config.apiToken)
      .ifPresent(token -> builder.addHeader(HttpHeaders.AUTHORIZATION, "token " + token));
    return builder.build();
  }

  private byte[] render(String content) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    new SourceStringReader(content).outputImage(outputStream);
    return outputStream.toByteArray();
  }
}
