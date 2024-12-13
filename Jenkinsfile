pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9' // Имя, которое вы указали в Global Tool Configuration
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Oleborn/reserchCICD.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t spring-boot-app:1.0 .'
            }
        }

        stage('Run Docker') {
            steps {
                sh '''
                docker stop spring-boot-app || true
                docker rm spring-boot-app || true
                docker run -d --name spring-boot-app -p 9090:8080 spring-boot-app:1.0
                '''
            }
        }
    }
}