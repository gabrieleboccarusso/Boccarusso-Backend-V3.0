FROM openjdk:17-jdk-slim
# FROM maven:3.9.0

COPY .mvn /app/mvn
# RUN ls /app/mvn

COPY src/ /app/src/
COPY ./pom.xml /app/

EXPOSE 8080

# database connection parameters
ARG DB_URL
ARG DB_USERNAME
ARG DB_PASSWORD

# database connection parameters
ARG MAX_POOL_SIZE
ARG MAX_CONNECTIONS

# security parameters
ARG USERNAME
ARG PASSWORD


RUN /app/mvn/mvnw -f /app/pom.xml clean package
CMD java -jar /app/target/boccarusso-3.0.0.jar