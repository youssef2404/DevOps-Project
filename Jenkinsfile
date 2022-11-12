

pipeline{

	agent any

	/*environment {
        dockerhub=credentials('dockerhub')
	}
       */
	stages {
	    
        stage ('Git Chekout') {
            steps {
                
                //git 'https://github.com/mhassini/timesheet-devops.git'
                git branch: 'main', 
                url: 'https://github.com/youssef2404/DevOps-Project.git'
                sh "git clone 'https://github.com/youssef2404/DevOps-Project.git'"
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
        
	}  
}
