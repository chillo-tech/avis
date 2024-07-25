pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-8' // Utilisez l'image Docker appropriée pour votre projet
        }
    }
    environment {
        DOCKER_HOST = 'tcp://jenkins-dind:2375'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/<votre-utilisateur>/<votre-repo>.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install' // Utilisez la commande de build appropriée pour votre projet
            }
        }
    }
}
