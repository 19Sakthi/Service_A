# Use OpenJDK 17 as base image
FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy built jar (Jenkins will build this in CI step)
COPY target/*.jar app.jar

# Expose the port used in your app
EXPOSE 8082

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
