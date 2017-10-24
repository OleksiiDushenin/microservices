FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade

RUN mkdir -p /usr/services/microservices/zipkin
ADD @project.build.finalName@.jar /usr/services/microservices/zipkin
ADD run.sh /usr/services/microservices/zipkin

EXPOSE 8762

WORKDIR /usr/services/microservices/zipkin

RUN chmod +x run.sh
CMD ./run.sh
