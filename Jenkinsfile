pipeline 
{
    agent any

    tools {
        maven "Maven_HOME"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Dipalib91/BDD_UI_Framework.git'

                // To run Maven on a Windows agent, use
                bat "mvn test -DthreadCount=1"
            }

            
        }
    }
