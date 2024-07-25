pipeline {
    agent {
        docker {
            image 'maven:3.8-openjdk-18-slim'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'docker --version'
            }
        }
    }
}
