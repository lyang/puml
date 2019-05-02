package lyang.puml.configurations;

import java.util.Map;

import javax.validation.constraints.NotNull;

public class GitHubConfig {
  public Map<String, Config> targets;

  public class Config {
    @NotNull
    public String endpoint;

    public String apiToken;
  }
}
