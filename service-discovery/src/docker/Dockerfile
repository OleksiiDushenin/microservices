FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade

COPY . /usr/services/microservices/service-discovery
WORKDIR /usr/services/microservices/service-discovery

EXPOSE 8761

CMD ["java", "-jar", "@project.build.finalName@.jar"]
