#!/usr/bin/env bash

export BUILD_NAME="1.0"

docker-compose -f docker/docker-compose.yml pull
docker-compose -f docker/docker-compose.yml up
