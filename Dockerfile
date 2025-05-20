FROM openjdk:23-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
COPY config/ config/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]