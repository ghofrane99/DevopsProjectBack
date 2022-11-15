pipeline {
  agent any 
  stages {
    stage('git checkout') {
      steps {
        git branch : 'CategorieProduit',
        url: 'https://github.com/ghofrane99/DevopsProjectBack.git';
	    
	 
        echo 'checkout stage'
           }
  
  }
 /* stage ('MVN BUILD') {
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
       
              sh 'mvn sonar:sonar -Dsonar.projectKey=ProjectDevops -Dsonar.host.url=http://172.10.0.140:9000 -Dsonar.login=603647c67fb9c37bcb3e07a92c47862f706ccb89'        
       }
      
    }
  
   stage ('NEXUS DEPLOY') {
       steps {
       sh 'mvn deploy -DaltDeploymentRepository=nexus::default::http://admin:nexus@172.10.0.140:8081/repository/ProjectDevops/'
        
      }
    }
   stage('Build Docker & tag'){
            steps{
                sh 'docker build -f Dockerfile -t projectdevops .'
		sh 'docker tag projectdevops youssefbriouza/projectdevops'
            }
        }
		 stage('Docker login & Push'){
            steps{
		sh 'docker login -u youssefbriouza -p vagrantvagrant'
                sh 'docker push youssefbriouza/projectdevops'
            }
        }*/
    stage('git checkout front') {
      steps {
        git branch : 'master',
        url : 'https://github.com/ghofrane99/DevopsProjectFront.git';
	      
        echo 'checkout stage'
	 /*sh'npm install --save @angular-devkit/build-angular'*/
           }
  }
	 stage ('ng test') {
      steps {
        sh 'ng version'
        echo 'test stage done'
      }
    }
	stage ('ng build') {
      steps {
        sh 'ng build'
	sh 'ls */*/*'
        echo 'Build stage done'
      }
    }
	stage ('Nexus DEPLOY') {
       steps {
	       
        sh 'npm --registry http://172.10.0.140:8081/repository/ProjectDevopsfront/'
        
      }
    }
		 /* stage('Build Docker & tag front'){
            steps{
                sh 'docker build -f Dockerfilefront -t projectdevopsfront .'
		sh 'docker tag projectdevops youssefbriouza/projectdevopsfront'
            }
        }
		 stage('Docker login & Push front'){
            steps{
		sh 'docker login -u youssefbriouza -p vagrantvagrant'
                sh 'docker push youssefbriouza/projectdevopsfront'
            }
        }
		stage('Start container') {
             steps {
                sh 'docker-compose up -d '
      }
        }*/
  }
  }
  /*post {
        always {
	emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}",
                recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']],
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
        }
	
    }
 }
*/
