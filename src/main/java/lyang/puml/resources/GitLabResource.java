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
import javax.ws.rs.core.Response;
import lyang.puml.PumlConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/gitlab")
public class GitLabResource extends GitResourceBase {
  public static final String GL_API = "https://%s/api/v4/projects/%s/repository/files/%s?ref=%s";
  public static final String GITLAB = "gitlab.com";

  @Inject
  public GitLabResource(OkHttpClient client, ObjectMapper mapper, PumlConfiguration configuration) {
    super(client, mapper, configuration);
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
    return get(pumlIndex, GITLAB, repo, path, commit);
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
    return get(host, pumlIndex, repo, path, commit);
  }

  @Override
  protected Request getRequest(Object... parts) {
    return new Request.Builder().url(String.format(GL_API, parts)).build();
  }
}
