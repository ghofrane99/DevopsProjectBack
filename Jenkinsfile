pipeline {
  agent any 
  stages {
    stage('Chekout GIT') {
      steps {
        echo 'Pulling...';
        git branch: 'Operateur' ,
          url : 'https://github.com/ghofrane99/DevopsProjectBack.git' ;
     
      }
    }
           stage("git last push time"){
            steps{
              
                  sh 'git log -1 --format=%cd '
                
                }
                
            }
}
