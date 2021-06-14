package lyang.puml.resources;

import lyang.puml.utils.Puml;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;

@Path("/referer")
public class RefererResource {

  private final OkHttpClient client;

  @Inject
  public RefererResource(OkHttpClient client) {
    this.client = client;
  }

  @GET
  @Produces("image/png")
  public Response get(
      @Context HttpHeaders headers, @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    Request request =
        new Request.Builder()
            .url(headers.getHeaderString("Referer"))
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build();
    try (okhttp3.Response response = client.newCall(request).execute()) {
      return Puml.renderToResponse(response.body().string(), pumlIndex).build();
    }
  }
}
