package lyang.puml;

import com.google.inject.Injector;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lyang.puml.resources.GitHubResource;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class PumlApplication extends Application<PumlConfiguration> {
  private GuiceBundle<Configuration> guiceBundle;

  public static void main(String[] args) throws Exception {
    new PumlApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<PumlConfiguration> bootstrap) {
    guiceBundle = GuiceBundle.builder().modules(new PumlModule()).build();
    bootstrap.addBundle(guiceBundle);
  }

  @Override
  public void run(PumlConfiguration configuration, Environment environment) {
    Injector injector = guiceBundle.getInjector();
    environment.jersey().register(injector.getInstance(GitHubResource.class));
  }
}
