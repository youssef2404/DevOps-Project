pipeline{
   agent any
   stages{
           stage('checkout GIT'){
		     steps{
			   echo 'pulling...';
			   echo date;
			   git branch: 'main',
			   url : 'https://github.com/youssef2404/DevOps-Project.git';
			 }
		   }
   }
}

