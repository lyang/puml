java_library(
    name = "jackson_annotations",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/com/fasterxml/jackson/core/jackson_annotations",
    ],
)

java_library(
    name = "jackson_core",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/com/fasterxml/jackson/core/jackson_core",
    ],
)

java_library(
    name = "jackson_databind",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jackson_annotations",
        ":jackson_core",
        "//external:jar/com/fasterxml/jackson/core/jackson_databind",
    ],
)
