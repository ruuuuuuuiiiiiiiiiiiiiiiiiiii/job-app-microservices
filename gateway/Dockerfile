FROM amazoncorretto:22-alpine-jdk

LABEL maintainer="Louie Laureles"

WORKDIR /app

COPY target/gateway-0.0.1-SNAPSHOT.jar gateway-app.jar

ENTRYPOINT ["java","-jar","gateway-app.jar"]