pipeline {
  agent any 
  stages {
    stage('git checkout') {
      steps {
        git branch : 'SecteurActivite',
        url: 'https://github.com/ghofrane99/DevopsProjectBack.git';
	    
	 
        echo 'checkout stage'
           }
  
  }
  stage ('MVN BUILD') {
      steps {
        sh 'mvn clean package'
        echo 'Build stage done'
      }
    }
  
    stage ('MVN COMPILE') {
      steps {
        sh 'mvn compile'
        echo 'compile stage done'

      }
    }
     stage ('MVN TEST') {
      steps {
        sh 'mvn test'
      }
    }
    
     stage ('STATIC TEST WITH SONAR') {
       steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=ProjectDevops -Dsonar.host.url=http://192.168.1.22:9000 -Dsonar.login=47608a0541100fb76d1506f99ade8076a5ad3d39'
      }
    }
  
   stage ('NEXUS DEPLOY') {
       steps {
       sh 'mvn deploy -DskipTests'
        
      }
    }
    /*stage('Build Docker'){
            steps{
                sh 'docker build -t oussemaaaa/cloudonomicsspring-app .'
            }
        }
		stage('Docker Login'){
            steps{
			
                sh 'docker login -u oussemaaaa -p benjou1998'
            }
        }
		 stage('Docker Push'){
            steps{
			
                sh 'docker push oussemaaaa/cloudonomicsspring-app'
            }
        }
		stage('Start container') {
             steps {
                sh 'docker-compose up -d '
      }
        }*/
    
    
    
    
    
  }  
  }
 /* post {
        always {
	emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
        }
	
    }
 }*/
