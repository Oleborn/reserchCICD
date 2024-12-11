tools {
    jdk 'JDK21'
}

pipeline {
    agent any

    stages {
    
        stage('Check Java Version') {
            steps {
                sh 'java -version'
            }
        }

        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Oleborn/reserchCICD.git'
            }
        }

        stage('Build') {
            steps {
                sh '''
                chmod +x ./mvnw
                ./mvnw clean package
                '''
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
                docker run -d --name spring-boot-app -p 8080:8080 spring-boot-app:1.0
                '''
            }
        }
    }
}