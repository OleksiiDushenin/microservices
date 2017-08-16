FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade

COPY . /usr/services/microservices/movies
WORKDIR /usr/services/microservices/movies

EXPOSE 8081

CMD ["java", "-jar", "@project.build.finalName@.jar"]
