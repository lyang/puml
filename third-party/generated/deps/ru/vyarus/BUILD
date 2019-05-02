java_library(
    name = "dropwizard_guicey",
    visibility = [
        "//visibility:public",
    ],
    exports = [
        ":generics_resolver",
        "//external:jar/ru/vyarus/dropwizard_guicey",
        "//third-party/generated/deps/com/google/inject:guice",
        "//third-party/generated/deps/com/google/inject/extensions:guice_servlet",
        "//third-party/generated/deps/io/dropwizard:dropwizard_core",
    ],
)

java_library(
    name = "generics_resolver",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/ru/vyarus/generics_resolver",
    ],
)
