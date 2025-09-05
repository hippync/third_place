plugins {
id("java")
id("org.springframework.boot") version "3.3.2"
id("io.spring.dependency-management") version "1.1.5"
}


group = "com.thirdplace"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_21


repositories { mavenCentral() }


dependencies {
implementation("org.springframework.boot:spring-boot-starter-web")
implementation("org.springframework.boot:spring-boot-starter-actuator")
implementation("org.springframework.boot:spring-boot-starter-data-jpa")
implementation("org.postgresql:postgresql:42.7.3")
implementation("org.springframework.boot:spring-boot-starter-validation")


testImplementation("org.springframework.boot:spring-boot-starter-test")
}


tasks.withType<Test> { useJUnitPlatform() }