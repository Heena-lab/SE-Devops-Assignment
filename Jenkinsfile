pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Heena-lab/SE-Devops-Assignment.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building...'
                bat 'javac Adder.java'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'java AdderTest'
            }
        }

        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging...'
                bat """xcopy /E /Y target\\* C:\\deployments\\staging"""
            }
        }

        stage('Deploy to Production') {
            input {
                message 'Approve deployment to production?'
            }
            steps {
                echo 'Deploying to production...'
                bat """xcopy /E /Y target\\* C:\\deployments\\production"""
            }
        }
    }

    post {
        failure {
            echo 'Build failed!'
        }
        success {
            echo 'Build succeeded!'
        }
    }
}
