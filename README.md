# lince-project-java

#DOCKER
mvn clean package dockerfile:build
docker run  --name lince-project -p 8080:8080 -t lince-open/lince-project:latest

