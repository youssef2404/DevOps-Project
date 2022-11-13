pipeline{

  agent any 
	stages {
	    
      /* stage ('Git Chekout') {
            steps {                
                git branch: 'main', 
                url: 'https://github.com/youssef2404/DevOps-Project.git'   
            }  
        }
        stage ('Maven Build') {
            steps {
                
                 sh 'mvn clean install'
            }
		        
        }
        stage ('Maven Compile') {
            steps {
                
                 sh 'mvn compile -e'
		        
            }
        }
        stage ('TEST Unitaire') {
            steps {
                
                 sh 'mvn clean test'
		        
            }
        }
        
        stage ('TEST Integration') {
            steps {
                
                 sh 'mvn verify -DskipUnitTests'
		        
            }
        }
		
	stage ('Packaging'){
			steps{
				sh "mvn package -Dmaven.test.skip=true"
			}
		}
        
        stage ('Maven SonarQube') {
            steps {
                
                 sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
		        
            }
        }
	 stage ('Deploiement Nexux'){
			steps{
				sh "mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.16:8081/repository/maven-releases -Dfile=target/tpAchatProject-1.0.jar"
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
