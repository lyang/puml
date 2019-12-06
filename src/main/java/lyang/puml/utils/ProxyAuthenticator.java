package lyang.puml.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class ProxyAuthenticator implements Authenticator {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProxyAuthenticator.class);
  private static final String PROXY_AUTHORIZATION = "Proxy-Authorization";

  @Override
  public Request authenticate(Route route, Response response) {
    if (isConfiguredFor(response.request())) {
      return setProxyAuth(response.request());
    }
    return null;
  }

  private boolean isConfiguredFor(Request request) {
    HttpUrl url = request.url();
    return url.host().equalsIgnoreCase(proxyHost(url.scheme())) && url.port() == proxyPort(url.scheme());
  }

  private Request setProxyAuth(Request request) {
    String scheme = request.url().scheme();
    String credential = Credentials.basic(proxyUser(scheme), proxyPassword(scheme));
    LOGGER.info("Authenticating with {}:{}", request.url().host(), request.url().port());
    LOGGER.info("Proxy User: {}", System.getProperty("https.proxyUser"));
    return request.newBuilder().addHeader(PROXY_AUTHORIZATION, credential).build();
  }

  private String proxyHost(String scheme) {
    return System.getProperty(scheme + ".proxyHost");
  }

  private int proxyPort(String scheme) {
    return Integer.parseInt(System.getProperty(scheme + ".proxyPort"));
  }

  private String proxyUser(String scheme) {
    return System.getProperty(scheme + ".proxyUser");
  }

  private String proxyPassword(String scheme) {
    return System.getProperty(scheme + ".proxyPassword");
  }
}
