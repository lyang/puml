package lyang.puml.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import lyang.puml.PumlConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/github")
public class GitHubResource extends GitResourceBase {
  public static final String GH_API = "https://api.%s/repos/%s/%s/contents/%s?ref=%s";
  public static final String GH_JSON = "application/vnd.github.v3+json";
  public static final String GITHUB = "github.com";

  @Inject
  public GitHubResource(OkHttpClient client, ObjectMapper mapper, PumlConfiguration config) {
    super(client, mapper, config);
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
    return get(pumlIndex, GITHUB, owner, repo, commit, path);
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
    return get(host, pumlIndex, owner, repo, commit, path);
  }

  @Override
  protected Request getRequest(Object... parts) {
    String url = String.format(GH_API, parts);
    return new Request.Builder().addHeader(HttpHeaders.ACCEPT, GH_JSON).url(url).build();
  }
}
