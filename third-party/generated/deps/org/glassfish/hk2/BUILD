java_library(
    name = "hk2_api",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":hk2_utils",
        "//external:jar/org/glassfish/hk2/hk2_api",
        "//third-party/generated/deps/javax/inject:javax_inject",
        "//third-party/generated/deps/org/glassfish/hk2/external:aopalliance_repackaged",
    ],
)

java_library(
    name = "hk2_locator",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":hk2_api",
        ":hk2_utils",
        "//external:jar/org/glassfish/hk2/hk2_locator",
        "//third-party/generated/deps/org/glassfish/hk2/external:aopalliance_repackaged",
        "//third-party/generated/deps/org/glassfish/hk2/external:javax_inject",
        "//third-party/generated/deps/org/javassist",
    ],
)

java_library(
    name = "hk2_utils",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/org/glassfish/hk2/hk2_utils",
        "//third-party/generated/deps/javax/inject:javax_inject",
    ],
)

java_library(
    name = "osgi_resource_locator",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/org/glassfish/hk2/osgi_resource_locator",
    ],
)
