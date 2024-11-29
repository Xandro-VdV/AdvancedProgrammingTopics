FROM openjdk:17-jdk-alpine
LABEL authors="Xandro"
EXPOSE 8081
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]