# =========================================================
# FASE 1: BUILD (Compilación)
# =========================================================

# Usa la imagen completa del JDK 21 (Java Development Kit) para compilar.
FROM eclipse-temurin:21-jdk-alpine AS builder

# Establece el directorio de trabajo dentro del contenedor.
WORKDIR /app

# Copia los archivos de configuración y el script de Gradle.
# Esto optimiza el caché de Docker.
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle/

# Otorga permisos de ejecución al script de Gradle (solución al error 126).
RUN chmod +x gradlew

# Copia el resto del código fuente.
COPY . .

# Compila la aplicación, saltando las pruebas unitarias para acelerar el build en la nube.
RUN ./gradlew clean build -x test

# =========================================================
# FASE 2: RUN (Ejecución - Imagen Final Ligera)
# =========================================================

# Usa la imagen del JRE 21 (Java Runtime Environment) que es mucho más ligera.
FROM eclipse-temurin:21-jre-alpine

# Establece el directorio de trabajo.
WORKDIR /app

# Copia el JAR ejecutable desde la fase 'builder'.
# Asegúrate de que el nombre del JAR sea EXACTO.
COPY --from=builder /app/build/libs/ms-db-client-0.0.1-SNAPSHOT.jar ./

# Exponer el puerto de Spring Boot (Render lo usará para dirigir el tráfico).
EXPOSE 8180 

# Comando para ejecutar la aplicación.
# Se ejecuta el JAR copiado.
CMD ["java", "-jar", "ms-db-client-0.0.1-SNAPSHOT.jar"]