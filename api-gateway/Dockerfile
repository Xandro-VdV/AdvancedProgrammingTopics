FROM openjdk:17-jdk-alpine
EXPOSE 8083
LABEL authors="Xandro"
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]