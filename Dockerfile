FROM openjdk:17-jdk-slim
# FROM maven:3.6.0

WORKDIR /app
COPY . /app

EXPOSE 8080

# RUN mvn clean package
CMD ["java", "-jar", "./target/boccarusso-3.0.0.jar"]