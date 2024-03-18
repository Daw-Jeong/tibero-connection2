#FROM maven:3.8.4-openjdk-17 AS build
#COPY src /usr/src/app/src
#COPY pom.xml /usr/src/app
#COPY src/main/resources/tibero6-jdbc.jar /usr/src/app/lib/
#RUN mvn -f /usr/src/app/pom.xml clean package
#
#FROM openjdk:17-jdk-slim
#COPY --from=build /usr/src/app/target/tibero-connection2-0.0.1-SNAPSHOT.jar /usr/app/tibero-connection2-0.0.1-SNAPSHOT.jar
#COPY --from=build /usr/src/app/lib/tibero6-jdbc.jar /usr/app/lib/
#ENTRYPOINT ["java","-jar","/usr/app/tibero-connection2-0.0.1-SNAPSHOT.jar"]


# 기본 이미지로 Maven과 OpenJDK가 포함된 이미지를 사용
FROM maven:3.8.4-openjdk-17 AS build
# 프로젝트 파일을 컨테이너의 /app 디렉토리로 복사
COPY . /app
# 작업 디렉토리를 /app으로 설정
WORKDIR /app
# Maven을 사용하여 프로젝트를 빌드
RUN mvn clean package

# 최종 이미지를 위해 OpenJDK만 포함된 기본 이미지를 사용합니다.
FROM openjdk:17-jdk-slim
# 빌드 스테이지에서 생성된 JAR 파일을 복사
COPY --from=build /app/target/tibero-connection2-0.0.1-SNAPSHOT.jar /app/tibero-connection2-0.0.1-SNAPSHOT.jar
# 작업 디렉토리를 /app으로 설정
WORKDIR /app
# 컨테이너 시작 시 Java 애플리케이션을 실행
ENTRYPOINT ["java","-jar","tibero-connection2-0.0.1-SNAPSHOT.jar"]