FROM maven:3.6.3-jdk-11

# Copy the project files to the container
COPY src /usr/src/campus/src
COPY pom.xml /usr/src/campus/pom.xml

# Set the working directory
WORKDIR /usr/src/campus

EXPOSE 8080


# Build the application
RUN mvn clean package spring-boot:repackage

ENTRYPOINT ["java", "-jar", "./target/CampusCMS-1.0-SNAPSHOT.jar"]