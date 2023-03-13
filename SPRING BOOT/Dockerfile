FROM openjdk:8-jdk-alpine
MAINTAINER srinivas
EXPOSE 9090
COPY target/REST-0.0.1-SNAPSHOT.jar weconnect.jar
ENTRYPOINT ["java","-jar","/weconnect.jar"]