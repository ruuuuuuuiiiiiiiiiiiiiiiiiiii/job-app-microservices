FROM amazoncorretto:22-alpine-jdk

LABEL maintainer="Louie Laureles"

WORKDIR /app

COPY target/companyms-0.0.1-SNAPSHOT.jar companyms-app.jar

ENTRYPOINT ["java","-jar","companyms-app.jar"]