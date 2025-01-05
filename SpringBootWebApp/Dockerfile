
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copy the pom.xml and download the dependencies
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Use an official OpenJDK runtime image for the final stage
FROM openjdk:17-jdk-slim
# Install necessary packages
RUN apt-get update && \
    apt-get install -y \
    # Installing libtcnative-1 if available
    libtcnative-1 || true

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/SpringBootWebApp-1.0.0.jar SpringBootWebApp.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/SpringBootWebApp.jar"]