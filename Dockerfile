FROM openjdk:11
EXPOSE 8089
RUN curl -u admin:admin123 http://192.168.1.28:8081/repository/ProjectDevOps/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar -O
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]
