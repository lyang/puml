#!/bin/bash

set -o errexit
set -o nounset
set -o pipefail

PORT=${PORT:-8080}
JVM_FLAGS=${JVM_FLAGS:-}
JAVABIN=$(which java)

PORT=$PORT JAVABIN=$JAVABIN JAVA_RUNFILES=/app ./puml --singlejar --jvm_flags="$JVM_FLAGS" server config.yaml
