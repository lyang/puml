package lyang.puml.resources;

import java.io.IOException;
import java.net.URL;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import lyang.puml.utils.Puml;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/raw/{url}")
public class RawResource {

  private OkHttpClient client;

  @Inject
  public RawResource(OkHttpClient client) {
    this.client = client;
  }

  @GET
  @Produces("image/png")
  public Response get(@PathParam("url") URL url,
      @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex) throws IOException {
    Request request = new Request.Builder().url(url).cacheControl(CacheControl.FORCE_NETWORK).build();
    try (okhttp3.Response response = client.newCall(request).execute()) {
      return Puml.renderToResponse(response.body().string(), pumlIndex).build();
    }
  }
}
