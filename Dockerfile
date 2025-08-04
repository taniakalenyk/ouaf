# Step 1: Build the jar using Maven inside Docker
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run the app with a lightweight JDK image
# Utiliser une image de base officielle Java
#FROM openjdk:17-jdk-alpine
FROM amazoncorretto:17-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/app.jar app.jar

# Copier le fichier .env dans le conteneur
COPY .env .env

# Exposer le port sur lequel l'application va tourner
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]