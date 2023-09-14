package lyang.puml.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import lyang.puml.PumlConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/gitlab")
@Produces("image/png")
public class GitLabResource extends GitResourceBase {
  public static final String GL_API = "https://%s/api/v4/projects/%s/repository/files/%s?ref=%s";
  public static final String GITLAB = "gitlab.com";

  @Inject
  public GitLabResource(OkHttpClient client, ObjectMapper mapper, PumlConfiguration configuration) {
    super(client, mapper, configuration);
  }

  @GET
  @Path("/projects/{repo}/files/{commit}/{path:.+}")
  public Response get(
      @PathParam("repo") String repo,
      @PathParam("commit") String commit,
      @PathParam("path") String path,
      @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    return get(pumlIndex, GITLAB, repo, path, commit);
  }

  @GET
  @Path("{host}/projects/{repo}/files/{commit}/{path:.+}")
  public Response get(
      @PathParam("host") String host,
      @PathParam("repo") String repo,
      @PathParam("commit") String commit,
      @PathParam("path") String path,
      @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    return get(host, pumlIndex, repo, path, commit);
  }

  @Override
  protected Request getRequest(Object... parts) {
    return new Request.Builder().url(String.format(GL_API, parts)).build();
  }
}
