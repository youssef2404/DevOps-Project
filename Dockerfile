FROM openjdk:8
EXPOSE 8089
ADD target/tpAchatProject.jar tpAchatProject.jar
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]
