# Use a base image with JDK
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
COPY target/SpringBootAdvanceMapping-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on (optional)
EXPOSE 9090 5432

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
