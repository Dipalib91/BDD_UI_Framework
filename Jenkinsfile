pipeline{
agent any
stages{
  stage('Build'){
  steps
  {
    echo "Building the code...."
    bat "mvn clean"
  }
}
stage('Test')
{
  steps
  {
     echo "Testing the code....."
     bat "mvn test -DthreadCount=1"
  }
}
stage('Compile')
{
  steps{
      echo "Compiling the Project"
      bat "mvn compile"
    }
 }
}
  post{
    always{
            emailext body: 'jenkins  job status', subject: 'status', to: 'seleniumtest61@gmail.com'
    }
  
}
}










