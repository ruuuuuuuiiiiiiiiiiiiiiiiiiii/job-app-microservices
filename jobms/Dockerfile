#CTTO Cameron McKenzie
FROM amazoncorretto:22-alpine-jdk

LABEL maintainer="Louie Laureles"

WORKDIR /app

COPY target/jobms-0.0.1-SNAPSHOT.jar jobms-app.jar

ENTRYPOINT ["java","-jar","jobms-app.jar"]

