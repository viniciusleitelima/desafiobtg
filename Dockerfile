FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080

RUN pwd

RUN ls

WORKDIR /applications

COPY target/desafiobtg-0.0.1-SNAPSHOT.jar /applications/desafiobtg.jar

ENTRYPOINT ["java","-jar", "application.jar"]

