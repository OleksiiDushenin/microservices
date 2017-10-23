FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade
RUN apt -y install netcat

RUN mkdir -p /usr/services/microservices/movies
ADD @project.build.finalName@.jar /usr/services/microservices/movies
ADD run.sh /usr/services/microservices/movies

EXPOSE 8081

WORKDIR /usr/services/microservices/movies

RUN chmod +x run.sh
CMD ./run.sh
