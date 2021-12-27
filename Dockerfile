FROM openjdk:13 as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:13
WORKDIR application
EXPOSE 7774

ENV NEWFRONT_REDIS_PASSWORD changeme
ENV JAVA_DEBUG ""
ENV NIVEL_LOG INFO
ENV JAVA_OPTS -Xms512m -Xmx768m

ENV ACTIVE_PROFILE dev
ENV SERVER_PORT 7774
ENV ENDERECO_SHAREPOINT "https://bancotoyota.sharepoint.com/sites"

COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/application/ ./

ENTRYPOINT java  org.springframework.boot.loader.JarLauncher \
--spring.profiles.active=${ACTIVE_PROFILE} --server.port=${SERVER_PORT} \
--sharepoint.url=${ENDERECO_SHAREPOINT} \
--logging.level.root=${NIVEL_LOG} \ 
--logging.level.access-log=${NIVEL_LOG} \
 ${JAVA_DEBUG} ${JAVA_OPTS}




