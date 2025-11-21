# Use the Eclipse temurin alpine official image
# https://hub.docker.com/_/eclipse-temurin
FROM eclipse-temurin:21-jdk-alpine

# =========================================================
# FASE 1: BUILD (Compilación)
# =========================================================

# Create and change to the app directory.
WORKDIR /app

# Copiar solo los archivos de configuración necesarios para las dependencias.
# Esto mejora el caché de Docker: si solo cambian las fuentes, no descarga deps.
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle/

# Otorgar permisos de ejecución al script de Gradle
RUN chmod +x gradlew

# Descargar dependencias y compilar la aplicación
# Copiar el resto del código (src)
COPY . ./

# Build the app.
# Usamos -x test para saltar las pruebas unitarias y acelerar el proceso.
RUN ./gradlew clean build -x test

# =========================================================
# FASE 2: RUN (Ejecución - Docker Multi-Stage Build)
# =========================================================

# Usamos una imagen base más ligera (JRE) para el entorno de ejecución
# Esto reduce el tamaño final del contenedor.
FROM eclipse-temurin:21-jre-alpine

# Crear el directorio de la aplicación en la imagen final
WORKDIR /app

# Copiar el archivo JAR generado desde la imagen de compilación anterior
# Asumiendo que usaste la etiqueta 'builder' para la primera fase (aunque no la definiste explícitamente, es buena práctica)
# Si no usas Multi-Stage, puedes copiar directamente el archivo.
# Por simplicidad aquí se asume que la fase 1 es la fase de build y la fase 2 es la de run.
COPY --from=0 /app/build/libs/ms-db-client-0.0.1-SNAPSHOT.jar ./

# Exponer el puerto de Spring Boot (ej. 8180)
EXPOSE 8180 

# Comando para ejecutar la aplicación.
# Este CMD es correcto si ese es el nombre EXACTO de tu JAR.
CMD ["java", "-jar", "ms-db-client-0.0.1-SNAPSHOT.jar"]