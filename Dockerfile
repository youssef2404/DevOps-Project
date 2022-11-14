FROM openjdk:8
ADD com/esprit/examen/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
EXPOSE 8089
ENTRYPOINT [ "java", "-jar", "tpAchatProject-1.0.jar" ]
