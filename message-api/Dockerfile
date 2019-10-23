# base image
FROM maven:3.6.1-jdk-8-slim as builder

WORKDIR /usr/app

COPY pom.xml .

RUN mvn dependency:resolve

COPY src ./src

RUN mvn package -DskipTests

RUN rm -rf ./src

FROM openjdk:8u111-jdk-alpine

WORKDIR /usr/app

COPY --from=builder /usr/app/target/message-api-1.0.0.jar ./app.jar

VOLUME /tmp

EXPOSE 5001

# default command to run every time container started
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=prod", "-jar","./app.jar"]