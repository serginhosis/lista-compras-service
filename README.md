# lista-compras-service
Api Rest feita em **Spring** + **Maven** + **Mysql** como banco de dados

# Documentação
A documentação da API está no **Swagger**, basta acessar host:porta/swagger-ui.html

# Docker
A aplicação contem os arquivos **Dockerfile** para buildar a imagem da aplicação e **docker-compose**, para subir com mysql

O Maven está configurado para usar o plugin do docker, para buildar a imagem basta rodar **mvn dockerfile:build**

# Kubernetes
Dentro da pasta Kubernetes tem todos os arquivos de configuração necessários para preparar o cluster

Dentro da pasta banco rodar os comandos em ordem:

 1- **kubectl create -f stateful-set.yaml**
 
 2- **kubectl create -f service-banco.yaml**
 
 3- **kubectl create -f permissoes.yaml**
 
Dentro da pasta aplicacao rodar os comandos em ordem:

 1 - **kubectl create -f deployment.yaml**
 
 2 - **kubectl create -f service-lista-compras.yaml**
