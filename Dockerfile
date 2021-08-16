FROM azul/zulu-openjdk-alpine:11

ADD target/paciente-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]