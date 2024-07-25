pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-8'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'docker --version'
                sh 'mvn clean install'
            }
        }
    }
}
