FROM openjdk:17


WORKDIR /app

COPY target/BackendRH-0.0.1-SNAPSHOT.jar /app/BackendRH.jar

EXPOSE 8080


CMD ["java", "-jar", "BackendRH.jar"]