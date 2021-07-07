FROM maven:3.5.3-jdk-8-alpine
WORKDIR /usr
COPY . /usr
RUN mvn dependency:go-offline -B