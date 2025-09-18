# ---- Build stage ----
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy parent pom and module poms first (for dependency cache)
COPY pom.xml .
COPY auth-core/pom.xml auth-core/
COPY auth-microservice/pom.xml auth-microservice/

# Download dependencies (caches this step)
RUN mvn dependency:go-offline

# Copy source code
COPY auth-core/src auth-core/src
COPY auth-microservice/src auth-microservice/src

# Build without tests
RUN mvn clean package -DskipTests

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copy only the microservice jar (lighter image)
COPY --from=builder /app/auth-microservice/target/*.jar app.jar

EXPOSE 8089
ENTRYPOINT ["java", "-jar", "app.jar"]
