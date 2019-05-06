package lyang.puml.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lyang.puml.configurations.AuthorizationHeader.Builder;
import okhttp3.Request;
import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
@JsonDeserialize(builder = Builder.class)
public interface AuthorizationHeader extends Credential {

  String TYPE = "auth-header";

  @JsonProperty("headerName")
  String getHeaderName();

  @JsonProperty("headerValue")
  String getHeaderValue();

  @Override
  default Request addToRequest(Request request) {
    return request.newBuilder().header(getHeaderName(), getHeaderValue()).build();
  }

  class Builder extends AuthorizationHeader_Builder {

  }
}
