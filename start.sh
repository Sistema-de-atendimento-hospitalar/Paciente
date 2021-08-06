#!/bin/bash

./mvnw clean install
echo 'sucesso ao buildar a aplicação'

docker build -t stefbitt/paciente-service-app .
echo 'sucesso ao buildar a imagem docker'

docker tag stefbitt/paciente-service-app:latest 251839969735.dkr.ecr.us-east-2.amazonaws.com/paciente-service-app:latest
echo 'criado tag da imagem'

aws ecr get-login-password | docker login --username AWS --password-stdin 251839969735.dkr.ecr.us-east-2.amazonaws.com    
echo 'sucesso login'

docker push 251839969735.dkr.ecr.us-east-2.amazonaws.com/paciente-service-app:latest
echo 'sucesso push'

