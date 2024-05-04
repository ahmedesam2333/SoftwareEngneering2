# Use the official Maven image for building
FROM maven:3.8.5-openjdk-17 AS maven_build

# Set the working directory
WORKDIR /tmp/

# Copy the project files
COPY pom.xml .
COPY src/ /tmp/src/

# Build the project
RUN mvn clean package

# Use the official OpenJDK 17 image for runtime
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the maven_build stage
COPY --from=maven_build /tmp/target/Taskaty-0.0.1-SNAPSHOT.jar .

# Expose port 8082
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "Taskaty-0.0.1-SNAPSHOT.jar"]
