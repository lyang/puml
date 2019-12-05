package lyang.puml.utils;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Objects;
import java.util.stream.Stream;

public class ProxyAuthenticator extends Authenticator {
  @Override
  protected PasswordAuthentication getPasswordAuthentication() {
    if (challengeFromProxy() && credentialSetForProtocol()) {
      return getProxyAuthentication();
    }
    return null;
  }

  private boolean challengeFromProxy() {
    return getRequestorType() == RequestorType.PROXY &&
           getRequestingPort() == proxyPort(getRequestingProtocol()) &&
           getRequestingHost().equalsIgnoreCase(proxyHost(getRequestingProtocol()));
  }

  private boolean credentialSetForProtocol() {
    return Stream.of("User", "Password")
      .map(setting -> getProxySetting(getRequestingProtocol(), setting))
      .allMatch(Objects::nonNull);
  }

  private PasswordAuthentication getProxyAuthentication() {
    return new PasswordAuthentication(proxyUser(getRequestingProtocol()), proxyPassword(getRequestingProtocol()));
  }

  private static String proxyHost(String protocol) {
    return getProxySetting(protocol, "Host");
  }

  private static int proxyPort(String protocol) {
    return Integer.parseInt(getProxySetting(protocol, "Port"));
  }

  private static String proxyUser(String protocol) {
    return getProxySetting(protocol, "User");
  }

  private static char[] proxyPassword(String protocol) {
    return getProxySetting(protocol, "Password").toCharArray();
  }

  private static String getProxySetting(String protocol, String property) {
    return System.getProperty(protocol + "." + property);
  }
}
