#!/usr/bin/env bash

export BUILD_NAME="0.1"

mvn clean package docker:build

docker-compose -f docker/docker-compose-test.yml up
