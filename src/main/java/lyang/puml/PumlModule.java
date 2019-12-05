package lyang.puml;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import lyang.puml.utils.AuthenticationHelper;
import lyang.puml.utils.ProxyAuthenticator;
import okhttp3.OkHttpClient;

public class PumlModule extends AbstractModule {

  @Provides
  @Singleton
  OkHttpClient httpClient(AuthenticationHelper authenticationHelper) {
    return new OkHttpClient.Builder()
      .addInterceptor(authenticationHelper)
      .proxyAuthenticator(new ProxyAuthenticator())
      .build();
  }

  @Provides
  @Singleton
  AuthenticationHelper authenticationHelper(PumlConfiguration configuration) {
    return new AuthenticationHelper(configuration.credentials);
  }
}
