FROM eclipse-temurin:17-jdk-alpine

COPY /home/runner/work/desafiobtg/desafiobtg/target/*.jar /app.jar

CMD ["java", "-jar", "/app.jar"]
