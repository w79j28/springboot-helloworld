
pipeline {
    agent any
    environment {
        REDISTOGO_URL = credentials('ra-redis-url')
        DOCKER_REGISTRY_IP_PORT = credentials('ra-docker-registry-ip-port')
        DATABASE_HOST = credentials('ra-database-host')
        DATABASE_PORT = credentials('ra-database-port')
        DATABASE_USERNAME = credentials('ra-database-username')
        DATABASE_PASSWORD = credentials('ra-database-password')
    }
    stages {
        stage('Start') {
            steps {
                slackSend message: 'CI/CD STARTED'
            }
        }
        

        stage('Tests') {
            steps {
                slackSend message: 'test...'
                script {
                    /*${env.DOCKER_REGISTRY_IP_PORT}/my-image:${env.BUILD_ID}*/
                    /**/
                    docker.image("192.168.15.120:5000/my-image:115").inside("-e REDISTOGO_URL=${env.REDISTOGO_URL} -e DATABASE_HOST=${env.DATABASE_HOST} -e DATABASE_PORT=${env.DATABASE_PORT} -e DATABASE_USERNAME=${env.DATABASE_USERNAME} -e DATABASE_PASSWORD=${env.DATABASE_PASSWORD}") {
                        /* Wait until postgres service is up */
                        /*sh 'RAILS_ENV=test bundle install'*/
                        sh 'RAILS_ENV=test bundle exec rake db:create'
                        /*sh 'RAILS_ENV=test bundle exec rake db:reset'
                        sh 'chmod -R a+x bin'
                        sh 'RAILS_ENV=test bundle exec rspec'*/
                    }
                    
                }
                
            }
            post {
                success {
                    slackSend message: 'tests success'
                }
                failure {
                    slackSend message: 'tests failure'
                }
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
