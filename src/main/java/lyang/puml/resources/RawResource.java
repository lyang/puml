package lyang.puml.resources;

import static okhttp3.CacheControl.FORCE_NETWORK;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import lyang.puml.utils.Puml;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Path("/raw/{url}")
public class RawResource {
  private final OkHttpClient client;

  @Inject
  public RawResource(OkHttpClient client) {
    this.client = client;
  }

  @GET
  @Produces("image/png")
  public Response get(
      @PathParam("url") URL url, @QueryParam("pumlIndex") @DefaultValue("0") int pumlIndex)
      throws IOException {
    Request request = new Request.Builder().url(url).cacheControl(FORCE_NETWORK).build();
    try (okhttp3.Response response = client.newCall(request).execute()) {
      String body = Objects.requireNonNull(response.body()).string();
      return Puml.renderToResponse(body, pumlIndex).build();
    }
  }
}
