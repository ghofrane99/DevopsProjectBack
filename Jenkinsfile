pipeline {
  agent any 
  stages {
    stage('Chekout GIT') {
      steps {
        echo 'Pulling...';
        git branch: 'master' ,
          url : 'https://github.com/ghofrane99/DevopsProjectBack.git' ;
     
      }
    }
    stage("Build") {
          sh "mvn compile"
}
stage("Unit tests") {
         sh "mvn test"
}
  
    
  }
}
