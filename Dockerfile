FROM openjdk:8-jdk-alpine
VOLUME /app
ARG DEPENDENCY=./
COPY ${DEPENDENCY}/target/desafio-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar","./app.jar"]
