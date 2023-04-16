FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080

RUN pwd

RUN ls

WORKDIR /applications

COPY target/application.jar /applications/application.jar

ENTRYPOINT ["java","-jar", "application.jar"]

