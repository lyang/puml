java_library(
    name = "jetty_continuation",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/org/eclipse/jetty/jetty_continuation",
    ],
)

java_library(
    name = "jetty_http",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jetty_io",
        ":jetty_util",
        "//external:jar/org/eclipse/jetty/jetty_http",
    ],
)

java_library(
    name = "jetty_io",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jetty_util",
        "//external:jar/org/eclipse/jetty/jetty_io",
    ],
)

java_library(
    name = "jetty_security",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jetty_server",
        "//external:jar/org/eclipse/jetty/jetty_security",
    ],
)

java_library(
    name = "jetty_server",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jetty_http",
        ":jetty_io",
        "//external:jar/org/eclipse/jetty/jetty_server",
        "//third-party/generated/deps/javax/servlet:javax_servlet_api",
    ],
)

java_library(
    name = "jetty_servlet",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jetty_security",
        "//external:jar/org/eclipse/jetty/jetty_servlet",
    ],
)

java_library(
    name = "jetty_servlets",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jetty_continuation",
        ":jetty_http",
        ":jetty_io",
        ":jetty_util",
        "//external:jar/org/eclipse/jetty/jetty_servlets",
    ],
)

java_library(
    name = "jetty_util",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        "//external:jar/org/eclipse/jetty/jetty_util",
    ],
)

java_library(
    name = "jetty_webapp",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jetty_servlet",
        ":jetty_xml",
        "//external:jar/org/eclipse/jetty/jetty_webapp",
    ],
)

java_library(
    name = "jetty_xml",
    visibility = [
        "//third-party/generated/deps:__subpackages__",
    ],
    exports = [
        ":jetty_util",
        "//external:jar/org/eclipse/jetty/jetty_xml",
    ],
)
