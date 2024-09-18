FROM amazoncorretto:22-alpine-jdk

LABEL maintainer="Louie Laureles"

WORKDIR /app

COPY target/reviewms-0.0.1-SNAPSHOT.jar reviewms-app.jar

ENTRYPOINT ["java","-jar","reviewms-app.jar"]