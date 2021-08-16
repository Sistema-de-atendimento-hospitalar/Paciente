#!/bin/bash

echo 'iniciando build da aplicação'
./mvnw clean install
echo 'sucesso ao buildar a aplicação'

echo 'iniciando build da imagem docker'
docker build -t stefbitt/paciente-service-app .
echo 'sucesso ao buildar a imagem docker'

echo 'criando tag docker'
docker tag stefbitt/paciente-service-app:latest 251839969735.dkr.ecr.us-east-2.amazonaws.com/paciente-service-app:latest
echo 'criado tag da imagem'

aws ecr get-login-password | docker login --username AWS --password-stdin 251839969735.dkr.ecr.us-east-2.amazonaws.com    
echo 'sucesso login'

echo 'iniciando push da imagem docker'
docker push 251839969735.dkr.ecr.us-east-2.amazonaws.com/paciente-service-app:latest
echo 'sucesso push'

