FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080

WORKDIR /home

RUN pwd

RUN ls

WORKDIR /applications

COPY /home/runner/work/desafiobtg/desafiobtg/target/desafiobtg-0.0.1-SNAPSHOT.jar /applications/desafiobtg.jar

ENTRYPOINT ["java","-jar", "application.jar"]

