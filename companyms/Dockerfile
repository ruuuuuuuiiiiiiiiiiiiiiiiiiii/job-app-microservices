FROM openjdk:22-jdk

WORKDIR /app

COPY target/jobapp-0.0.1-SNAPSHOT.jar /app/jobapp.jar

ENV APP_PORT=2020

EXPOSE $APP_PORT

CMD ["java", "-jar", "jobapp.jar"]