FROM maven:3.8.4-openjdk-17 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
COPY src/main/resources/tibero6-jdbc.jar /usr/src/app/lib/
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:17-jdk-slim
COPY --from=build /usr/src/app/target/tibero-connection2-0.0.1-SNAPSHOT.jar /usr/app/tibero-connection2-0.0.1-SNAPSHOT.jar
COPY --from=build /usr/src/app/lib/tibero6-jdbc.jar /usr/app/lib/
ENTRYPOINT ["java","-jar","/usr/app/tibero-connection2-0.0.1-SNAPSHOT.jar"]