#!/bin/bash

set -o errexit
set -o nounset
set -o pipefail

PORT=${PORT:-8080} JAVABIN=/usr/bin/java JAVA_RUNFILES=/app ./puml --singlejar --jvm_flags="${JVM_ARGS:-}" server config.yaml
