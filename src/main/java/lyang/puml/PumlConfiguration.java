package lyang.puml;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.dropwizard.Configuration;
import java.util.List;
import java.util.Map;
import lyang.puml.configurations.Credential;

public class PumlConfiguration extends Configuration {
  public List<Credential> credentials = ImmutableList.of();
  public Map<String, String> hostMappings = ImmutableMap.of();
}
