FROM openjdk:8

RUN apt -y update
RUN apt -y upgrade
RUN apt -y install netcat

RUN mkdir -p /usr/services/microservices/recommendations
ADD @project.build.finalName@.jar /usr/services/microservices/recommendations
ADD run.sh /usr/services/microservices/recommendations

EXPOSE 8082

WORKDIR /usr/services/microservices/recommendations

RUN chmod +x run.sh
CMD ./run.sh
