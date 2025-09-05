# Build stage: use official Gradle image (includes JDK)
FROM gradle:8.10.0-jdk21-alpine AS build
WORKDIR /home/gradle/src
# Copy everything (including gradlew + gradle/wrapper)
COPY --chown=gradle:gradle . .
RUN ./gradlew clean bootJar

# Runtime stage: slim JRE
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]