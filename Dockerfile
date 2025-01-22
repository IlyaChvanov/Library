FROM openjdk:17

WORKDIR /app

COPY build/libs/library-1.0.0-SNAPSHOT.jar library-1.0.0.jar
COPY src/main/resources/data.sql data.sql

CMD ["java", "-jar", "library-1.0.0.jar"]