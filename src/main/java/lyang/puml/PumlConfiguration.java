package lyang.puml;

import java.util.List;

import com.google.common.collect.ImmutableList;

import io.dropwizard.Configuration;
import lyang.puml.configurations.Credential;

public class PumlConfiguration extends Configuration {
  public List<Credential> credentials = ImmutableList.of();
}
