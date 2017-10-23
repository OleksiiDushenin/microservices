#!/usr/bin/env bash

echo "********************************************************"
echo "Waiting for the config server to start on port 8888"
echo "********************************************************"
while ! `nc -z config-server 8888`; do sleep 3; done
echo "**"

java -jar /usr/services/microservices/service-discovery/@project.build.finalName@.jar
