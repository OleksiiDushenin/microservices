FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade

COPY . /usr/services/microservices/zuul
WORKDIR /usr/services/microservices/zuul

EXPOSE 5555

CMD ["java", "-jar", "@project.build.finalName@.jar"]
