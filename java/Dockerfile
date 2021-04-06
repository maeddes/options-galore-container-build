FROM maven:3.6.3-jdk-11 AS build
RUN mkdir -p /opt/app/src
COPY src /opt/app/src
COPY pom.xml /opt/app
RUN mvn -f /opt/app/pom.xml clean package

FROM adoptopenjdk:11-jre-hotspot
COPY --from=build /opt/app/target/simplecode-0.0.1-SNAPSHOT.jar /opt/app.jar
CMD ["java","-jar","/opt/app.jar"]
