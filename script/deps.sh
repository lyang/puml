#!/bin/bash
set -o errexit
set -o nounset
BAZEL_DEPS_GITHUB="https://github.com/johnynek/bazel-deps"
TEMP_DIR=/tmp
ROOT_DIR=$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)
DEP=${2:-}

setup-bazel-deps() {
  pushd $TEMP_DIR
  if [ -d "bazel-deps" ]; then
    cd bazel-deps && git pull
  else
    git clone $BAZEL_DEPS_GITHUB
  fi
  popd
}

bazel-deps() {
  pushd $TEMP_DIR/bazel-deps && bazel run //:parse -- $@
  popd
}

add() {
  bazel-deps add-dep -l java -d ${ROOT_DIR}/third-party/deps.yaml $1
  generate
}

generate() {
  bazel-deps format-deps -o -d ${ROOT_DIR}/third-party/deps.yaml
  bazel-deps generate -r $ROOT_DIR -s third-party/generated/workspace/workspace.bzl -d third-party/deps.yaml
  find ${ROOT_DIR}/third-party/ \( -name 'BUILD' -or -name '*.bzl' \) -exec "buildifier" -showlog -mode=fix {} +
}

setup-bazel-deps

case ${1:-g} in
  add)
    add $DEP
    ;;
  generate)
    generate
    ;;
  *)
    echo 'Usage: script/deps.sh (add <maven-coordinate>|generate)'
    echo "For more details: $BAZEL_DEPS_GITHUB"
esac
