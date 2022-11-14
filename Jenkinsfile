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


 stage('MVN SONARQUBE'){
            steps{
              mvn sonar:sonar \
  -Dsonar.projectKey=tpAchatProject \
  -Dsonar.host.url=http://192.168.1.40:9000 \
  -Dsonar.login=b6d8bb0affbc375f55884947900433dabf884461
            }
        }
        stage('JUNIT-MOCKITO'){
            steps{
                echo'laching units test ...'
                sh 'mvn test'
            }
        }
}

}
