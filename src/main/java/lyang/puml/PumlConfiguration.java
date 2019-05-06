package lyang.puml;

import io.dropwizard.Configuration;
import java.util.List;
import lyang.puml.configurations.Credential;

public class PumlConfiguration extends Configuration {

  public List<Credential> credentials;
}
