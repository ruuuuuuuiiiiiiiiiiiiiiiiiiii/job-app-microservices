FROM amazoncorretto:22-alpine-jdk

LABEL maintainer="Louie Laureles"

WORKDIR /app

COPY target/config-server-0.0.1-SNAPSHOT.jar config-server-app.jar

ENTRYPOINT ["java","-jar","config-server-app.jar"]