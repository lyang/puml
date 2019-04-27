java_library(
    name = "metrics_annotation",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/io/dropwizard/metrics/metrics_annotation",
        "//third-party/generated/deps/org/slf4j:slf4j_api",
    ],
)

java_library(
    name = "metrics_core",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/io/dropwizard/metrics/metrics_core",
    ],
)

java_library(
    name = "metrics_healthchecks",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/io/dropwizard/metrics/metrics_healthchecks",
    ],
)

java_library(
    name = "metrics_jersey2",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":metrics_annotation",
        ":metrics_core",
        "//external:jar/io/dropwizard/metrics/metrics_jersey2",
    ],
)

java_library(
    name = "metrics_jetty9",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":metrics_core",
        "//external:jar/io/dropwizard/metrics/metrics_jetty9",
    ],
)

java_library(
    name = "metrics_jmx",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":metrics_core",
        "//external:jar/io/dropwizard/metrics/metrics_jmx",
    ],
)

java_library(
    name = "metrics_json",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":metrics_core",
        "//external:jar/io/dropwizard/metrics/metrics_json",
    ],
)

java_library(
    name = "metrics_jvm",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":metrics_core",
        "//external:jar/io/dropwizard/metrics/metrics_jvm",
    ],
)

java_library(
    name = "metrics_logback",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":metrics_core",
        "//external:jar/io/dropwizard/metrics/metrics_logback",
    ],
)

java_library(
    name = "metrics_servlets",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":metrics_core",
        ":metrics_healthchecks",
        ":metrics_json",
        ":metrics_jvm",
        "//external:jar/io/dropwizard/metrics/metrics_servlets",
        "//third-party/generated/deps/com/papertrail:profiler",
    ],
)
