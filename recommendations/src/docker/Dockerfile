FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade

COPY . /usr/services/microservices/recommendations
WORKDIR /usr/services/microservices/recommendations

EXPOSE 8082

CMD ["java", "-jar", "@project.build.finalName@.jar"]
