FROM openjdk:8-alpine
ADD target/tpAchatProject.jar tpAchatProject.jar
EXPOSE 8089
ENTRYPOINT [ "java", "-jar", "tpAchatProject-1.0.jar" ]
