package lyang.puml.resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.sourceforge.plantuml.SourceStringReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/github")
public class GitHubResource {
  private static final String GITHUB_RAW_FORMAT = "application/vnd.github.v3.raw";

  @GET
  @Produces("image/png")
  @Path("/{host}/{user}/{repo}/{path:.+}")
  public Response get(@PathParam("host") String host,
                      @PathParam("user") String user,
                      @PathParam("repo") String repo,
                      @PathParam("path") String path) throws IOException {
    try (okhttp3.Response response = new OkHttpClient().newCall(buildRequest(host, user, repo, path)).execute()) {
      return Response.ok(render(response.body().string())).build();
    }
  }

  private Request buildRequest(String host, String user, String repo, String path) {
    String url = String.format("https://%s/repos/%s/%s/contents/%s", host, user, repo, path);
    return new Request.Builder().addHeader(HttpHeaders.ACCEPT, GITHUB_RAW_FORMAT).url(url).get().build();
  }

  private byte[] render(String content) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    new SourceStringReader(content).outputImage(outputStream);
    return outputStream.toByteArray();
  }
}
