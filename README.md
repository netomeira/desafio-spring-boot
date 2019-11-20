# Desafio Spring Boot
API REST implementada em Spring Boot

# Stack
* Spring Boot
* Spring Data
* Spring Boot Actuator
* Swagger 2
* H2
* JUnit 5

# Funcionalidades
* Validação de parâmetros de entrada
* Queries modulares com Specification
* Tratamento de exceções centralizado com RestControllerAdvice
* Testes unitários mockados com Mockito

# Entidades
1. Cidade:
* nome
* estado

2. Cliente:
* nome
* gênero
* data de nascimento
* cidade
* idade (dado transiente)

# Endpoints
Lista disponivel em localhost:8080/swagger-ui.html

# Getting Started
Para iniciar o projeto, execute:

```sh
mvn spring-boot:run
```

Para gerar o relatório de cobertura de testes, execute:

```sh
mvn test
```