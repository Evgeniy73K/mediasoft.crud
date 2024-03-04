FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY app.jar app.jar

CMD ["java", "-jar", "app.jar"]
