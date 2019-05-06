package lyang.puml.configurations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.regex.Pattern;
import lyang.puml.configurations.RequestMatcher.Builder;
import okhttp3.Request;
import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
@JsonDeserialize(builder = Builder.class)
public interface RequestMatcher {

  @JsonProperty("pattern")
  String getPattern();

  default boolean matches(Request request) {
    return Pattern.compile(getPattern()).matcher(request.url().toString()).matches();
  }

  class Builder extends RequestMatcher_Builder {

  }
}
