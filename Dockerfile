FROM openjdk:17-jdk-slim

WORKDIR /app
COPY . /app

EXPOSE 8080

RUN ["./mvnw", "clean", "package"]
CMD ["java", "-jar", "./target/boccarusso-3.0.0.jar"]