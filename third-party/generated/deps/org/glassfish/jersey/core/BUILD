java_library(
    name = "jersey_client",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jersey_common",
        "//external:jar/org/glassfish/jersey/core/jersey_client",
        "//third-party/generated/deps/javax/ws/rs:javax_ws_rs_api",
        "//third-party/generated/deps/org/glassfish/hk2:hk2_api",
        "//third-party/generated/deps/org/glassfish/hk2:hk2_locator",
        "//third-party/generated/deps/org/glassfish/hk2/external:javax_inject",
    ],
)

java_library(
    name = "jersey_common",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/org/glassfish/jersey/core/jersey_common",
        "//third-party/generated/deps/javax/annotation:javax_annotation_api",
        "//third-party/generated/deps/javax/ws/rs:javax_ws_rs_api",
        "//third-party/generated/deps/org/glassfish/hk2:hk2_api",
        "//third-party/generated/deps/org/glassfish/hk2:hk2_locator",
        "//third-party/generated/deps/org/glassfish/hk2:osgi_resource_locator",
        "//third-party/generated/deps/org/glassfish/hk2/external:javax_inject",
        "//third-party/generated/deps/org/glassfish/jersey/bundles/repackaged:jersey_guava",
    ],
)

java_library(
    name = "jersey_server",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jersey_client",
        ":jersey_common",
        "//external:jar/org/glassfish/jersey/core/jersey_server",
        "//third-party/generated/deps/javax/annotation:javax_annotation_api",
        "//third-party/generated/deps/javax/validation:validation_api",
        "//third-party/generated/deps/javax/ws/rs:javax_ws_rs_api",
        "//third-party/generated/deps/org/glassfish/hk2:hk2_api",
        "//third-party/generated/deps/org/glassfish/hk2:hk2_locator",
        "//third-party/generated/deps/org/glassfish/hk2/external:javax_inject",
        "//third-party/generated/deps/org/glassfish/jersey/media:jersey_media_jaxb",
    ],
)
