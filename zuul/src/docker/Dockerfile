FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade
RUN apt -y install netcat

RUN mkdir -p /usr/services/microservices/zuul
ADD @project.build.finalName@.jar /usr/services/microservices/zuul
ADD run.sh /usr/services/microservices/zuul

EXPOSE 5555

WORKDIR /usr/services/microservices/zuul

RUN chmod +x run.sh
CMD ./run.sh
