package lyang.puml;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import okhttp3.OkHttpClient;

public class PumlModule extends AbstractModule {
  @Provides
  @Singleton
  OkHttpClient httpClient() {
    return new OkHttpClient();
  }
}
