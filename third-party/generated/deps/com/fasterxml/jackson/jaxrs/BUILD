java_library(
    name = "jackson_jaxrs_base",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/com/fasterxml/jackson/jaxrs/jackson_jaxrs_base",
        "//third-party/generated/deps/com/fasterxml/jackson/core:jackson_core",
        "//third-party/generated/deps/com/fasterxml/jackson/core:jackson_databind",
    ],
)

java_library(
    name = "jackson_jaxrs_json_provider",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jackson_jaxrs_base",
        "//external:jar/com/fasterxml/jackson/jaxrs/jackson_jaxrs_json_provider",
        "//third-party/generated/deps/com/fasterxml/jackson/module:jackson_module_jaxb_annotations",
    ],
)
