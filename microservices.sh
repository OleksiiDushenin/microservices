#!/usr/bin/env bash

export BUILD_NAME="1.0"

mvn clean package docker:build

docker-compose -f docker/docker-compose.yml up
