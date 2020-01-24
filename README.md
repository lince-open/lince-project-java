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

![](https://github.com/lince-open/lince-project-java/workflows/Java%20CI/badge.svg)
[![Known Vulnerabilities](https://snyk.io/test/github/lince-open/lince-project-java/badge.svg)](https://snyk.io/test/github/pedrozatta/lince-project-java)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=lince-open_lince-project-java&metric=coverage)](https://sonarcloud.io/dashboard?id=lince-open_lince-project-java)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=lince-open_lince-project-java&metric=alert_status)](https://sonarcloud.io/dashboard?id=lince-open_lince-project-java)

## Docker Hub

https://hub.docker.com/repository/docker/linceopen/lince-project

mvn clean package dockerfile:build

docker run --name lince-project \
-e LINCE_KVS_PORT='8080' \
-e LINCE_KVS_DATASOURCE_URL='jdbc:h2:file:~/lince-project' \
-e LINCE_JAVA_OPT='-Xms64m -Xmx128m' \
-p 51001:8080 \
-t lince-open/lince-kvs:latest

docker tag lince-open/lince-project:latest linceopen/lince-project:0.0.10

docker push linceopen/lince-project:0.0.10

docker tag lince-open/lince-project:latest linceopen/lince-project:latest

docker push linceopen/lince-project:latest

## Execução
mvn spring-boot:run

