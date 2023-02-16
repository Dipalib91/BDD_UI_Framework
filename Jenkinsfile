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
stages('Compile')
{
steps{
echo "Compiling the Project"
bat "mvn compile"
}
}
}
}
