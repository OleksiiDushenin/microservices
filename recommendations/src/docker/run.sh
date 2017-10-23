#!/usr/bin/env bash

echo "********************************************************"
echo "Waiting for the config server to start on port 8888"
echo "********************************************************"
while ! `nc -z config-server 8888`; do sleep 3; done
echo "**"

echo "********************************************************"
echo "Waiting for the eureka server to start on port 8761"
echo "********************************************************"
while ! `nc -z discovery 8761`; do sleep 3; done
echo "**"

export ENCRYPT_KEY=changeme

java -jar /usr/services/microservices/recommendations/@project.build.finalName@.jar
