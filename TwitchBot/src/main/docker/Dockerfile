FROM openjdk:16-jdk-slim as builder
WORKDIR application
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:16-jdk-slim

WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

EXPOSE 7001
ENV JAVA_OPTS=""
CMD exec java $JAVA_OPTS -Duser.timezone=Europe/Prague -Djava.security.egd=file:/dev/./urandom org.springframework.boot.loader.JarLauncher