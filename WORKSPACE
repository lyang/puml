workspace(name = "puml")

load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("//third-party/generated/workspace:workspace.bzl", "maven_dependencies")

maven_dependencies()

git_repository(
    name = "io_bazel_rules_docker",
    remote = "https://github.com/bazelbuild/rules_docker.git",
    tag = "v0.7.0",
)

load(
    "@io_bazel_rules_docker//repositories:repositories.bzl",
    container_repositories = "repositories",
)

container_repositories()

load(
    "@io_bazel_rules_docker//container:container.bzl",
    "container_pull",
)

container_pull(
    name = "openjdk8",
    registry = "index.docker.io",
    repository = "linyang1218/java-graphviz",
    tag = "8-stretch",
)

container_pull(
    name = "openjdk11",
    registry = "index.docker.io",
    repository = "linyang1218/java-graphviz",
    tag = "11-stretch",
)
