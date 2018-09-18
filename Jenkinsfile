
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
                    sh 'docker rmi -f 192.168.15.120:5000/my-image:48'
                }
                slackSend message: 'deploy'
            }
        }
    }
}
