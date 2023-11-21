FROM openjdk:11
LABEL authors="ozanaslan"
ARG JAR_FILE=target/*.jar
COPY ./target/CampusCMS-1.0-SNAPSHOT.jar spring.jar

ENTRYPOINT ["java", "-jar", "/spring.jar"]