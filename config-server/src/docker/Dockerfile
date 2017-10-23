FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade

RUN mkdir -p /usr/services/microservices/config-server
ADD @project.build.finalName@.jar /usr/services/microservices/config-server
ADD run.sh /usr/services/microservices/config-server

EXPOSE 8888

WORKDIR /usr/services/microservices/config-server

RUN chmod +x run.sh
CMD ./run.sh

