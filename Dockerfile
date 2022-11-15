FROM openjdk:11
EXPOSE 8089
RUN curl -u admin:nexus http://192.168.100.120:8081/repository/ProjectDevops/com/esprit/examen/tpAchatProject/2.0/tpAchatProject-2.0.jar -O
ENTRYPOINT ["java","-jar","tpAchatProject-2.0.jar"]
