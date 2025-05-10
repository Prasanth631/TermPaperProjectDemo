pipeline {
    agent any
    tools {
        maven 'Maven 3'
        jdk 'Java 11'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/login-ci-demo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Archive Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
    post {
        always {
            mail to: 'prasanthgolla29@gmail.com',
                 subject: "Jenkins Job: ${env.JOB_NAME} [#${env.BUILD_NUMBER}]",
                 body: "Build completed. Check results at: ${env.BUILD_URL}"
        }
    }
}
