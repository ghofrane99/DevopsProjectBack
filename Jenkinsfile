pipeline {
  agent any 
  stages {
    stage('git checkout') {
      steps {
        git branch : 'Operateur',
        url : 'https://github.com/ghofrane99/DevopsProjectBack.git';
	      
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
                sh 'mvn sonar:sonar -Dsonar.projectKey=ProjectDevops -Dsonar.host.url=http://192.168.100.120:9000 -Dsonar.login=47536d40d88aa4ba3860a5661342baf702b645eb'
      }
    }
  
   stage ('NEXUS DEPLOY') {
       steps {
        sh 'mvn deploy -DaltDeploymentRepository=nexus::default::http://admin:vagrant@192.168.100.120:8081/repository/ProjectDevops/'
        
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
        }
    stage('git checkout front') {
      steps {
        git branch : 'master',
        url : 'https://github.com/ghofrane99/DevopsProjectFront.git';
	      
        echo 'checkout stage'
	 sh'ls -la'
           }
  }
	/* stage ('ng test') {
      steps {
        sh 'ng test'
        echo 'test stage done'
      }
    }*/
	stage ('ng build') {
      steps {
        sh 'ng build'
        echo 'Build stage done'
      }
    }
	stage ('Nexus DEPLOY') {
       steps {
        sh 'npm publish'
        
      }
    }
		  stage('Build Docker & tag front'){
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
        }
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
