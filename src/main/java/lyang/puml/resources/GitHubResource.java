package lyang.puml.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/github")
public class GitHubResource {
  @GET
  @Path("/{host}/{user}/{repo}/{path:.+}")
  public Response getSVG(@PathParam("host") String host,
                         @PathParam("user") String user,
                         @PathParam("repo") String repo,
                         @PathParam("path") String path) {
    return Response.ok().entity(String.format("%s/%s/%s/%s", host, user, repo, path)).build();
  }
}
