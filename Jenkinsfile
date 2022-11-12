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
                sh 'mvn sonar:sonar -Dsonar.projectKey=ProjectDevops -Dsonar.host.url=http://192.168.1.28:9000 -Dsonar.login=47608a0541100fb76d1506f99ade8076a5ad3d39'
      }
    }
  
   stage("publish to nexus") {
	   steps {
                sh 'mvn deploy -DaltDeploymentRepository=nexus::default::http://admin:admin123@192.168.1.28:8081/repository/ProjectDevOps/'
	   }
   }
    stage('Build Docker'){
            steps{
                sh 'docker build -t projectdevops/projetdevops .'
            }
        }
		stage('Docker Login'){
            steps{
			
                sh 'docker login -u mariemb -p 181JFT1453'
            }
        }
		 stage('Docker Push'){
            steps{
			
                sh 'docker push projectdevops/projectdevops'
            }
        }
	/*	stage('Start container') {
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
