FROM eclipse-temurin:17-jdk-alpine

COPY target/desafiobtg-0.0.1-SNAPSHOT.jar /app.jar

CMD ["java", "-jar", "/app.jar"]