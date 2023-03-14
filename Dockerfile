FROM openjdk:17-jdk-slim

WORKDIR /app
COPY . /app

EXPOSE 8080

CMD ["./mvnw", "clean", "package"], ["java", "-jar", "./target/boccarusso-3.0.0.jar"]