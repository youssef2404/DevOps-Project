pipeline {
    agent any 
    
    stages {
        stage ('Checkout GIT') {
            steps {
                echo 'Pulling... ';
                git branch: 'eyaStock',
                url : 'https://github.com/youssef2404/DevOps-Project.git';
            }
        }
        stage('MVN CLEAN'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('MVN COMPILE'){
            steps{
                sh 'mvn compile'
            }
        }
        /*stage('MVN SONARQUBE'){
            steps{
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.16:9000 -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
        stage('JUNIT-MOCKITO'){
            steps{
                echo'laching units test ...'
                sh 'mvn test'
            }
        }
        stage('Nexus'){
            steps{
                sh 'mvn deploy'
            }
        }
        
       	stage("Building image") {
            steps {
                sh 'docker build -t eya25/achat .'
            }
        }
        stage('Docker Login') {
            steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u="eya25" -p="Eyaayouta123!!!" '
			}
		} 
	    stage('Push') {
            steps {
				sh 'docker push eya25/achat'
			}
     	}*/
     	
     	stage('deploy docker-compose'){
            steps{
                script{
                    sh 'docker-compose up -d'
                }
            }
	    }
    }
   /* post {
		always {
			sh 'docker logout'
		}
        	}*/
}
