package lyang.puml.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/github")
public class GitHubResource {
  private static final String GITHUB_RAW_FORMAT = "application/vnd.github.v3.raw";

  @GET
  @Path("/{host}/{user}/{repo}/{path:.+}")
  public Response getSVG(@PathParam("host") String host,
                         @PathParam("user") String user,
                         @PathParam("repo") String repo,
                         @PathParam("path") String path) throws IOException {
    String url = String.format("https://%s/repos/%s/%s/contents/%s", host, user, repo, path);
    Request request = new Request.Builder().addHeader(HttpHeaders.ACCEPT, GITHUB_RAW_FORMAT).url(url).get().build();
    try (okhttp3.Response response = new OkHttpClient().newCall(request).execute()) {
      return Response.ok().entity(response.body().string()).build();
    }
  }
}
