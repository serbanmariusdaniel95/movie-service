FROM openjdk:17.0-jdk

EXPOSE 8081

ADD target/movie-service-1.0-SNAPSHOT.jar movie-service-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/movie-service-1.0-SNAPSHOT.jar"]