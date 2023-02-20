FROM maven:3.6.3-openjdk-11-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY springboot-rest-api/pom.xml /build/
COPY springboot-rest-api/src /build/src/

RUN mvn clean package
COPY target/springboot-rest-api-${VERSION}.jar target/application.jar

FROM openjdk:11.0.8-jre-slim
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar
