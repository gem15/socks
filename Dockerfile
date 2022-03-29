FROM openjdk:8-jdk-alpine
LABEL maintaner="gem"
ENV TZ=Europe/Moscow
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]