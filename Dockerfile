FROM openjdk:11
EXPOSE 8089
RUN curl -u admin:nexus http://172.168.0.140:8081/repository/ProjectDevops/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar -O
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]
