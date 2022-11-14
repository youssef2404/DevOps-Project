pipeline {
    agent any

    stages {
        stage('Git checkout') {
            steps {
                git branch: 'ons', 
credentialsId: 'c9f553ba-99cd-4cc6-b9b3-75aa29e75a35', 
url: 'https://github.com/youssef2404/DevOps-Project.git'
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
stage ('Packaging'){
			steps{
				sh "mvn package -Dmaven.test.skip=true"
			}
		}

   stage('MVN SONARQUBE'){
            steps{
                sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.1.40:9000 -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
        stage('JUNIT-MOCKITO'){
            steps{
                echo'laching units test ...'
                sh 'mvn test'
            }
        }
       
 stage ('Deploiement Nexux'){
			steps{
				sh "mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.41:8081/repository/maven-releases -Dfile=target/tpAchatProject-1.0.jar"
			}
		}
		
	 stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t youssef2404/youssef .'
                }
            }
        }
         stage('Docker Login') {
            steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u="youssef2404" -p="Youssef92183494" '
			}
		} 
	 stage('Push DockerHub') {
             steps {
		    sh 'docker push youssef2404/youssef'
			}
	    post {
		always {
			sh 'docker logout'
		}
        	}
     	}*/
	stage('Docker compose') {
            steps {
                sh 'docker compose build'
                sh 'docker compose up -d'
	    }	}
	
		
	
	}  
}

}

}
