FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_File=target/*.jar

WORKDIR /javafolder

COPY ${JAR_File} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]