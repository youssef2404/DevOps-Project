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
        


 stage('MVN SONARQUBE'){
            steps{
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=12345'
            }
        }
       
}

}
