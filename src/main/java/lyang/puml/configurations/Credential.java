package lyang.puml.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import okhttp3.Request;

@JsonTypeInfo(
    use = Id.NAME,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = AuthorizationHeader.class, name = AuthorizationHeader.TYPE),
})
public interface Credential {

  @JsonProperty("requestMatcher")
  RequestMatcher getRequestMatcher();

  Request addToRequest(Request request);
}
