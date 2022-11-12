pipeline{
  agent any 
	stages {
	    
       stage ('Git Chekout') {
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
        
        stage ('Maven SonarQube') {
            steps {
                
                 sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
		        
            }
        }
	 stage ('Deploiement dans Nexux...'){
			steps{
				sh "mvn -Dmaven.test.skip=true -Dmaven.test.failure.ignore=true deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.16:8081/repository/maven-releases -Dfile=target/tpAchatProject-1.0.jar"
			}
		}
        
	}  
}
