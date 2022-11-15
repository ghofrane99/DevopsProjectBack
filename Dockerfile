FROM openjdk:11
EXPOSE 8089
RUN curl -u admin:nexus http://192.168.100.120:8081/repository/ProjectDevOps/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar -O
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]
