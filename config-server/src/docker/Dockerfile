FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade

COPY . /usr/services/microservices/config-server
WORKDIR /usr/services/microservices/config-server

EXPOSE 8888

CMD ["java", "-jar", "@project.build.finalName@.jar"]
