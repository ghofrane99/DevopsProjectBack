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
    stage('Clean') {
      steps {
          sh 'mvn clean'
      } }
    stage('Build') {
      steps {
          sh 'mvn compile'
      } }
stage('Unit tests') {
  steps {
         sh 'mvn test'
  }                }
  
    
  }
}

