package lyang.puml;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class PumlApplication extends Application<PumlConfiguration> {
  public static void main(String[] args) throws Exception {
    new PumlApplication().run(args);
  }

  @Override
  public void run(PumlConfiguration configuration, Environment environment) {
  }
}
