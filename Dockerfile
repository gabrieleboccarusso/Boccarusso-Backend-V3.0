FROM openjdk:17-jdk-slim
FROM maven:3.9.0

# COPY ./ /app
COPY src/ /app/src/
COPY ./pom.xml /app/

EXPOSE 8080

RUN export $(cat /etc/secrets/env | xargs)

RUN mvn -f /app/pom.xml clean package
CMD java -jar /app/target/boccarusso-3.0.0.jar