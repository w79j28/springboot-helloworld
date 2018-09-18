
pipeline {
    agent any
    environment {
        REDISTOGO_URL = credentials('ra-redis-url')
        DOCKER_REGISTRY_IP_PORT = credentials('ra-docker-registry-ip-port')
        /*DATABASE_HOST = credentials('ra-database-host')
        DATABASE_PORT = credentials('ra-database-port')
        DATABASE_USERNAME = credentials('ra-database-username')
        DATABASE_PASSWORD = credentials('ra-database-password')*/
    }
    stages {
        stage('Start') {
            steps {
                slackSend message: 'CI/CD STARTED'
            }
        }
   
        stage('Deploy') {
            steps {

                script {
                    acsDeploy azureCredentialsId: 'azure_service_principal', configFilePaths: 'hello-test.yaml', containerService: 'rawebkubernetes | AKS', dcosDockerCredentialsPath: '', enableConfigSubstitution: true, resourceGroupName: 'raweb917', secretName: '', sshCredentialsId: 'slave_ssh_key'

                }
                slackSend message: 'deploy'
            }
        }
    }
}
