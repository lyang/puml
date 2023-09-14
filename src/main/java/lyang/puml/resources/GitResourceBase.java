package lyang.puml.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ObjectArrays;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import lyang.puml.PumlConfiguration;
import lyang.puml.utils.Puml;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public abstract class GitResourceBase {
  private final OkHttpClient client;
  private final ObjectMapper mapper;
  private final Map<String, String> hostMappings;

  protected GitResourceBase(OkHttpClient client, ObjectMapper mapper, PumlConfiguration config) {
    this.client = client;
    this.mapper = mapper;
    this.hostMappings = config.hostMappings;
  }

  protected Response get(String host, int pumlIndex, Object... parts) throws IOException {
    if (hostMappings.containsKey(host)) {
      return get(pumlIndex, ObjectArrays.concat(hostMappings.get(host), parts));
    } else {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
  }

  protected Response get(int pumlIndex, Object... parts) throws IOException {
    try (okhttp3.Response response = client.newCall(getRequest(parts)).execute()) {
      return Puml.renderToResponse(getContent(response), pumlIndex).build();
    }
  }

  private String getContent(okhttp3.Response response) throws IOException {
    ResponseBody responseBody = Objects.requireNonNull(response.body());
    String encoded = mapper.readTree(responseBody.byteStream()).at("/content").asText();
    return new String(Base64.getDecoder().decode(encoded.replaceAll("\n", "")));
  }

  protected abstract Request getRequest(Object... parts);
}
