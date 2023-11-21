# Step 1: Use the official Maven image to create a build stage
FROM maven:3.6.3-jdk-11

# Copy the project files to the container
COPY src /usr/src/myapp/src
COPY pom.xml /usr/src/myapp/pom.xml

# Set the working directory
WORKDIR /usr/src/myapp

EXPOSE 8080

# Build the application
RUN mvn spring-boot:run
