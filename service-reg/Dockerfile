FROM amazoncorretto:22-alpine-jdk

LABEL maintainer="Louie Laureles"

WORKDIR /app

COPY target/service-reg-0.0.1-SNAPSHOT.jar service-reg-app.jar

ENTRYPOINT ["java","-jar","service-reg-app.jar"]