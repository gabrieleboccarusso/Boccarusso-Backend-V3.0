FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . . 

EXPOSE 8080

# security parameters
ARG USERNAME
ARG PASSWORD

RUN ./mvnw clean package
CMD java -jar /app/target/boccarusso-3.0.0.jar