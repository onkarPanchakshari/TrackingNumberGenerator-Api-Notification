FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /app
COPY generator-api-notification/pom.xml .
COPY generator-api-notification/src ./src
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]