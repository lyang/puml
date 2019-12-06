package lyang.puml;

import com.google.inject.Injector;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lyang.puml.resources.RawResource;
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
    SubstitutingSourceProvider sourceProvider =
      new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                                     new EnvironmentVariableSubstitutor(false));
    bootstrap.setConfigurationSourceProvider(sourceProvider);
  }

  @Override
  public void run(PumlConfiguration configuration, Environment environment) {
    Injector injector = guiceBundle.getInjector();
    environment.jersey().register(injector.getInstance(RawResource.class));
  }
}
