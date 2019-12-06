package lyang.puml.utils;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class ProxyAuthenticator implements Authenticator {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProxyAuthenticator.class);
  private static final String PROXY_AUTHORIZATION = "Proxy-Authorization";

  @Override
  public Request authenticate(Route route, Response response) {
    if (Objects.isNull(response.request().header(PROXY_AUTHORIZATION))) {
      return setProxyAuth(route, response.request());
    }
    return null;
  }

  private Request setProxyAuth(Route route, Request request) {
    String scheme = request.url().scheme();
    String credential = Credentials.basic(proxyUser(scheme), proxyPassword(scheme));
    LOGGER.info("Authenticating {}@{}", proxyUser(scheme), route.proxy().address());
    return request.newBuilder().addHeader(PROXY_AUTHORIZATION, credential).build();
  }

  private String proxyUser(String scheme) {
    return System.getProperty(scheme + ".proxyUser");
  }

  private String proxyPassword(String scheme) {
    return System.getProperty(scheme + ".proxyPassword");
  }
}
