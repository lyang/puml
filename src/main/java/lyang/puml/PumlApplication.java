package lyang.puml;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class PumlApplication extends Application<PumlConfiguration> {

  public static void main(String[] args) throws Exception {
    new PumlApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<PumlConfiguration> bootstrap) {
    bootstrap.addBundle(
        GuiceBundle.builder()
            .modules(new PumlModule())
            .enableAutoConfig(getClass().getPackageName())
            .build());
    SubstitutingSourceProvider sourceProvider =
        new SubstitutingSourceProvider(
            bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false));
    bootstrap.setConfigurationSourceProvider(sourceProvider);
  }

  @Override
  public void run(PumlConfiguration configuration, Environment environment) {}
}
