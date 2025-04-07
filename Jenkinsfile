pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Heena-lab/SE-Devops-Assignment.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project with Maven...'
                bat 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                bat 'mvn test'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging...'
                bat 'xcopy /E /Y target\* C:\\deployments\\staging'
            }
        }

        stage('Deploy to Production') {
            input {
                message 'Approve deployment to production?'
            }
            steps {
                echo 'Deploying to production...'
                bat 'xcopy /E /Y target\* C:\\deployments\\production'
            }
        }
    }

    post {
        failure {
            echo 'Build failed!'
        }
    }
}
