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
                // bat "mvn test -DthreadCount=1"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
