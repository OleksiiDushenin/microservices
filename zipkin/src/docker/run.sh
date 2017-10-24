#!/usr/bin/env bash

export ENCRYPT_KEY=changeme

java -jar /usr/services/microservices/zipkin/@project.build.finalName@.jar
