# lince-project-java
Microservice de Cadastro de Projetos, permite a inclusão, alteração exclusão e pesquisa de Projetos.
Quando um projeto é adicionado, o usuário autenticado é registrado como owner.

* Solução
* Persistencia Spring Data e JPA
* Autenticação com Spring Security e uso de Header
* Testes Unitários com JUnit/Spock/Groove
* Testes Funcionais com JUnit/Spock/Groove
* Swagger2
* Docker

## Docker Hub

https://hub.docker.com/repository/docker/linceopen/lince-project

mvn clean package dockerfile:build

docker run  --name lince-project -p 8080:8080 -t lince-open/lince-project:latest

docker tag lince-open/lince-project:latest linceopen/lince-project:latest

docker push linceopen/lince-project:latest

## Execução
mvn spring-boot:run

