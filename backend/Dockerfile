# Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src
RUN ./gradlew clean bootJar || (apt-get update && apt-get install -y wget unzip && \
wget -q https://services.gradle.org/distributions/gradle-8.10-bin.zip && \
unzip -q gradle-8.10-bin.zip && ln -s gradle-8.10 /opt/gradle && \
PATH=/opt/gradle/bin:$PATH gradle wrapper && ./gradlew clean bootJar)


# Runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]