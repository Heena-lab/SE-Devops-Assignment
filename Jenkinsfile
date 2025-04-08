pipeline {
    agent any

    environment {
        STAGING_DIR = 'C:\\deployments\\staging'
        PROD_DIR = 'C:\\deployments\\production'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Heena-lab/SE-Devops-Assignment.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy to Staging') {
            steps {
                bat "mkdir \"${env.STAGING_DIR}\""
                bat "xcopy /E /Y target\\* \"${env.STAGING_DIR}\""
            }
        }

        stage('Deploy to Production') {
            when {
                branch 'main'
            }
            steps {
                bat "mkdir \"${env.PROD_DIR}\""
                bat "xcopy /E /Y target\\* \"${env.PROD_DIR}\""
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
