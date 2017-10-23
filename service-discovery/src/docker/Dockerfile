FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade
RUN apt -y install netcat

RUN mkdir -p /usr/services/microservices/service-discovery
ADD @project.build.finalName@.jar /usr/services/microservices/service-discovery
ADD run.sh /usr/services/microservices/service-discovery

EXPOSE 8761

WORKDIR /usr/services/microservices/service-discovery

RUN chmod +x run.sh
CMD ./run.sh
