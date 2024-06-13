#FROM openjdk:8-jdk-alpine
FROM eclipse-temurin:21-alpine

#LABEL authors="backend-surtidor"
#MAINTAINER baeldung.com

# Refer to Maven build -> finalName
#ARG JAR_FILE=target/eurekaserver-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=target/*.war

#WORKDIR /opt/app
#WORKDIR /app

# cp target/{jarfileName}.jar /opt/app/app.jar
#COPY target/backendspring-0.0.1-SNAPSHOT.war service.war
COPY ${JAR_FILE} service.war

#EXPOSE 8380

ENTRYPOINT ["java","-jar","service.war"]