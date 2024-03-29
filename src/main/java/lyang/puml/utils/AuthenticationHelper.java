package lyang.puml.utils;

import java.io.IOException;
import java.util.List;
import lyang.puml.configurations.Credential;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("ClassCanBeRecord")
public class AuthenticationHelper implements Interceptor {
  private final List<Credential> credentials;

  public AuthenticationHelper(List<Credential> credentials) {
    this.credentials = credentials;
  }

  @NotNull
  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request =
        credentials.stream()
            .filter(credential -> credential.getRequestMatcher().matches(chain.request()))
            .findFirst()
            .map(credential -> credential.addToRequest(chain.request()))
            .orElse(chain.request());
    return chain.proceed(request);
  }
}
