Microsserviço de Categorias – Projeto Final Gestão Financeira Pessoal
Descrição
Este é o microsserviço responsável pela gestão das categorias de gasto dentro do sistema de Gestão Financeira Pessoal.

Desenvolvido em Spring Boot, com persistência em PostgreSQL, comunicação assíncrona via RabbitMQ (Producer) e documentação gerada com Swagger.

Tecnologias utilizadas
Java 17

Spring Boot

PostgreSQL

RabbitMQ

Swagger (OpenAPI)

Maven

Funcionalidades implementadas
CRUD completo de Categorias (Create, Read, Update, Delete)

Swagger para documentação dos endpoints

Configuração de CORS global

Integração com RabbitMQ como Producer

Endpoints disponíveis
Operação	Método HTTP	Endpoint
Listar todas as categorias	GET	/categories
Buscar uma categoria por ID	GET	/categories/{id}
Criar nova categoria	POST	/categories
Atualizar uma categoria existente	PUT	/categories/{id}
Deletar uma categoria	DELETE	/categories/{id}

Exemplo Body para POST (JSON)
json
Copy
{
  "nome": "Alimentação",
  "descricao": "Gastos com comida"
}
Configuração de CORS
Configurado para permitir requisições de qualquer origem, permitindo o consumo pelo aplicativo Flutter.

Integração com RabbitMQ
Este microsserviço envia mensagens para a fila RabbitMQ toda vez que uma nova categoria é criada.

Como rodar localmente
Tenha o PostgreSQL e RabbitMQ rodando localmente.

Configure o arquivo application.properties com as credenciais necessárias.

Execute no terminal:

bash
Copy
mvnw spring-boot:run
