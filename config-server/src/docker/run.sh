#!/usr/bin/env bash

export ENCRYPT_KEY=changeme

java -jar /usr/services/microservices/config-server/@project.build.finalName@.jar
