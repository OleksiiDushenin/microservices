#!/usr/bin/env bash

echo "Building by travis: $BUILD_NAME ..."
mvn clean package docker:build
