java_library(
    name = "dropwizard_configuration",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_jackson",
        ":dropwizard_validation",
        "//external:jar/io/dropwizard/dropwizard_configuration",
        "//third-party/generated/deps/com/fasterxml/jackson/dataformat:jackson_dataformat_yaml",
        "//third-party/generated/deps/org/apache/commons:commons_lang3",
        "//third-party/generated/deps/org/apache/commons:commons_text",
    ],
)

java_library(
    name = "dropwizard_core",
    visibility = [
        "//visibility:public",
    ],
    exports = [
        ":dropwizard_configuration",
        ":dropwizard_jackson",
        ":dropwizard_jersey",
        ":dropwizard_jetty",
        ":dropwizard_lifecycle",
        ":dropwizard_logging",
        ":dropwizard_metrics",
        ":dropwizard_request_logging",
        ":dropwizard_servlets",
        ":dropwizard_util",
        ":dropwizard_validation",
        "//external:jar/io/dropwizard/dropwizard_core",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_core",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_healthchecks",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_jmx",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_jvm",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_servlets",
        "//third-party/generated/deps/net/sourceforge/argparse4j",
        "//third-party/generated/deps/org/eclipse/jetty/toolchain/setuid:jetty_setuid_java",
    ],
)

java_library(
    name = "dropwizard_jackson",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_util",
        "//external:jar/io/dropwizard/dropwizard_jackson",
        "//third-party/generated/deps/com/fasterxml/jackson/core:jackson_annotations",
        "//third-party/generated/deps/com/fasterxml/jackson/core:jackson_core",
        "//third-party/generated/deps/com/fasterxml/jackson/core:jackson_databind",
        "//third-party/generated/deps/com/fasterxml/jackson/datatype:jackson_datatype_guava",
        "//third-party/generated/deps/com/fasterxml/jackson/datatype:jackson_datatype_jdk8",
        "//third-party/generated/deps/com/fasterxml/jackson/datatype:jackson_datatype_joda",
        "//third-party/generated/deps/com/fasterxml/jackson/datatype:jackson_datatype_jsr310",
        "//third-party/generated/deps/com/fasterxml/jackson/module:jackson_module_afterburner",
        "//third-party/generated/deps/com/fasterxml/jackson/module:jackson_module_parameter_names",
        "//third-party/generated/deps/com/google/guava",
        "//third-party/generated/deps/org/slf4j:slf4j_api",
    ],
)

java_library(
    name = "dropwizard_jersey",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_jackson",
        ":dropwizard_logging",
        ":dropwizard_validation",
        "//external:jar/io/dropwizard/dropwizard_jersey",
        "//third-party/generated/deps/com/fasterxml/jackson/jaxrs:jackson_jaxrs_json_provider",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_jersey2",
        "//third-party/generated/deps/org/apache/commons:commons_lang3",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_continuation",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_server",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_webapp",
        "//third-party/generated/deps/org/glassfish/jersey/containers:jersey_container_servlet",
        "//third-party/generated/deps/org/glassfish/jersey/core:jersey_server",
        "//third-party/generated/deps/org/glassfish/jersey/ext:jersey_bean_validation",
        "//third-party/generated/deps/org/glassfish/jersey/ext:jersey_metainf_services",
    ],
)

java_library(
    name = "dropwizard_jetty",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_logging",
        "//external:jar/io/dropwizard/dropwizard_jetty",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_jetty9",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_http",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_server",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_servlet",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_servlets",
    ],
)

java_library(
    name = "dropwizard_lifecycle",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_util",
        "//external:jar/io/dropwizard/dropwizard_lifecycle",
        "//third-party/generated/deps/com/google/guava",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_server",
        "//third-party/generated/deps/org/slf4j:slf4j_api",
    ],
)

java_library(
    name = "dropwizard_logging",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_jackson",
        ":dropwizard_validation",
        "//external:jar/io/dropwizard/dropwizard_logging",
        "//third-party/generated/deps/ch/qos/logback:logback_classic",
        "//third-party/generated/deps/ch/qos/logback:logback_core",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_logback",
        "//third-party/generated/deps/org/eclipse/jetty:jetty_util",
        "//third-party/generated/deps/org/slf4j:jcl_over_slf4j",
        "//third-party/generated/deps/org/slf4j:jul_to_slf4j",
        "//third-party/generated/deps/org/slf4j:log4j_over_slf4j",
        "//third-party/generated/deps/org/slf4j:slf4j_api",
    ],
)

java_library(
    name = "dropwizard_metrics",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_jackson",
        ":dropwizard_lifecycle",
        ":dropwizard_validation",
        "//external:jar/io/dropwizard/dropwizard_metrics",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_core",
        "//third-party/generated/deps/org/slf4j:slf4j_api",
    ],
)

java_library(
    name = "dropwizard_request_logging",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_jetty",
        ":dropwizard_logging",
        "//external:jar/io/dropwizard/dropwizard_request_logging",
        "//third-party/generated/deps/ch/qos/logback:logback_access",
    ],
)

java_library(
    name = "dropwizard_servlets",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_util",
        "//external:jar/io/dropwizard/dropwizard_servlets",
        "//third-party/generated/deps/ch/qos/logback:logback_classic",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_annotation",
        "//third-party/generated/deps/io/dropwizard/metrics:metrics_core",
        "//third-party/generated/deps/org/slf4j:slf4j_api",
    ],
)

java_library(
    name = "dropwizard_util",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/io/dropwizard/dropwizard_util",
        "//third-party/generated/deps/com/fasterxml/jackson/core:jackson_annotations",
        "//third-party/generated/deps/com/google/code/findbugs:jsr305",
        "//third-party/generated/deps/com/google/guava",
        "//third-party/generated/deps/joda_time",
    ],
)

java_library(
    name = "dropwizard_validation",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":dropwizard_util",
        "//external:jar/io/dropwizard/dropwizard_validation",
        "//third-party/generated/deps/org/glassfish:javax_el",
        "//third-party/generated/deps/org/hibernate:hibernate_validator",
        "//third-party/generated/deps/org/javassist",
        "//third-party/generated/deps/org/slf4j:slf4j_api",
    ],
)
