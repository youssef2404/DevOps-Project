pipeline {
 
 agent any
 stages {
 stage('Cloning Project from Git') {
 steps { 
sh "git clone 'https://github.com/youssef2404/DevOps-Project.git'"
 }
 }
stage("Build") {
 steps {
 sh "mvn compile"
}}
stage("Unit tests") {
 steps {
 sh "mvn test"
}}
stage("sonar") {
 steps {
 sh "mvn sonar:sonar"
}}
stage ("clean et packaging"){
 steps {
 bat "mvn clean install "
 }}



}
}

