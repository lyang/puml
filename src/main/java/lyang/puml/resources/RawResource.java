package lyang.puml.resources;

import static okhttp3.CacheControl.FORCE_NETWORK;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
