# Use a imagem oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o código fonte para o container
COPY . /app

# Adicione permissões de execução para o mvnw
RUN chmod +x ./mvnw

# Exponha a porta que o microsserviço vai rodar
EXPOSE 8080

# Comando para construir o JAR dentro do container
RUN ./mvnw clean install -DskipTests

# Execute o aplicativo
ENTRYPOINT ["java", "-jar", "target/categorias-0.0.1-SNAPSHOT.jar"]
