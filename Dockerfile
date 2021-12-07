#Contruir imagem
#    docker build -t <IMAGE-NAME> -f ./Dockerfile .
#Rodar os testes
#    docker run --ipc=host -v "$PWD/target:/usr/target" <IMAGE-NAME>:latest mvn test "-Dcucumber.options=--tags ''" -Denv=des
FROM mcr.microsoft.com/playwright/java:focal
WORKDIR /usr
COPY . /usr
RUN mvn dependency:go-offline -B