package lyang.puml.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import lyang.puml.PumlConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/github")
@Produces("image/png")
public class GitHubResource extends GitResourceBase {
  public static final String GH_API = "https://api.%s/repos/%s/%s/contents/%s?ref=%s";
  public static final String GH_JSON = "application/vnd.github.v3+json";
  public static final String GITHUB = "github.com";

  @Inject
  public GitHubResource(OkHttpClient client, ObjectMapper mapper, PumlConfiguration config) {
    super(client, mapper, config);
  }

  @GET
  @Path("/{owner}/{repo}/blob/{commit}/{path:.+}")
  public Response get(
      @PathParam("owner") String owner,
      @PathParam("repo") String repo,
      @PathParam("commit") String commit,
      @PathParam("path") String path,
      @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    return get(pumlIndex, GITHUB, owner, repo, path, commit);
  }

  @GET
  @Path("{host}/{owner}/{repo}/blob/{commit}/{path:.+}")
  public Response get(
      @PathParam("host") String host,
      @PathParam("owner") String owner,
      @PathParam("repo") String repo,
      @PathParam("commit") String commit,
      @PathParam("path") String path,
      @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    return get(host, pumlIndex, owner, repo, path, commit);
  }

  @Override
  protected Request getRequest(Object... parts) {
    String url = String.format(GH_API, parts);
    return new Request.Builder().addHeader(HttpHeaders.ACCEPT, GH_JSON).url(url).build();
  }
}
