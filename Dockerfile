# Use the Eclipse temurin alpine official image
FROM eclipse-temurin:21-jdk-alpine

# Create and change to the app directory.
WORKDIR /app

# Copia los archivos del proyecto (incluyendo gradlew)
COPY . ./

# **********************************************
# LÍNEA CRUCIAL: OTORGAR PERMISOS
# **********************************************
RUN chmod +x gradlew

# Build the app.
# Esta línea FALLA si la anterior no se ejecuta
RUN ./gradlew clean build -x test

# ... (El resto del Dockerfile)