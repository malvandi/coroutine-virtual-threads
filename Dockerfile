# Build stage
FROM maven:3.9.8-eclipse-temurin-22-jammy AS build
LABEL authors="m.malvandi"

WORKDIR /app
COPY pom.xml /app
COPY src /app/src

RUN mvn clean package

# Runtime stage
FROM eclipse-temurin:22-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
