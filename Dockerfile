# Use a imagem oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR gerado para o container
COPY target/categorias-0.0.1-SNAPSHOT.jar categorias.jar

# Exponha a porta que o microsserviço vai rodar
EXPOSE 8080

# Execute o aplicativo
ENTRYPOINT ["java", "-jar", "categorias.jar"]
