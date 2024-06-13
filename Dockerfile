#FROM openjdk:8-jdk-alpine
FROM eclipse-temurin:21-alpine

#LABEL authors="backend-surtidor"
#MAINTAINER baeldung.com

# Refer to Maven build -> finalName
ARG JAR_FILE=target/eurekaserver-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# cp target/{jarfileName}.jar /opt/app/app.jar
#COPY ${JAR_FILE} app.jar
COPY target/springboot-0.0.1-SNAPSHOT.war service.war

ENTRYPOINT ["java","-jar","/service.war"]