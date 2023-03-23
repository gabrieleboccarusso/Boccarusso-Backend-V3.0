FROM openjdk:17-jdk-slim
FROM maven:3.9.0

COPY src/ /app/src/
COPY ./pom.xml /app/

EXPOSE 8080

# security parameters
ARG USERNAME
ARG PASSWORD

RUN mvn -f /app/pom.xml clean package
RUN java -jar /app/target/boccarusso-3.0.0.jar