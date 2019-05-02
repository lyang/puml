#!/bin/bash

REVISION=$(git rev-parse HEAD)
echo "STABLE_BUILD_REVISION ${REVISION}"
