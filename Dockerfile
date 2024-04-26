FROM openjdk:17-jdk-slim
COPY build/libs/* app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]