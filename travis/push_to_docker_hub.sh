#!/usr/bin/env bash

echo "Pushing images to docker hub ...."
docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD

docker push alexeydushenin/dushenin.oleksii.microservices.zipkin::$BUILD_NAME
docker push alexeydushenin/dushenin.oleksii.microservices.zuul:$BUILD_NAME
docker push alexeydushenin/dushenin.oleksii.microservices.discovery:$BUILD_NAME
docker push alexeydushenin/dushenin.oleksii.microservices.config:$BUILD_NAME
docker push alexeydushenin/dushenin.oleksii.microservices.recommendations:$BUILD_NAME
docker push alexeydushenin/dushenin.oleksii.microservices.movies:$BUILD_NAME
