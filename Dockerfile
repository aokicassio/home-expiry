FROM openjdk:11-jre-slim
WORKDIR /app

COPY ./target/*.jar ./expiry.jar
ENTRYPOINT ["java", "-jar", "/app/expiry.jar"]

EXPOSE 8080