
# Utilizar la imagen oficial de OpenJDK 21
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor Animal-Shelter-0.0.1-SNAPSHOT.jar
COPY target/Animal-Shelter-0.0.1-SNAPSHOT.jar Animal-Shelter.jar

# Exponer el puerto en el que la aplicación se ejecuta
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "Animal-Shelter.jar"]