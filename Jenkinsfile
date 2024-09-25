pipeline {
    agent any

    tools {
        maven 'Maven' // Specify your Maven version here
        jdk 'JDK21' // Specify your JDK version here
        git 'Git' // Optional, if you have Git configured
    }

    environment {
        GITHUB_CREDENTIALS = credentials('evy') // Use credentials stored in Jenkins
    }

    stages {
        stage('Clone Repository') {
            steps {
                // Clone the GitHub repository
                git url: 'git@github.com:evyco3/PipelineAutomation.git', credentialsId: 'evy'
            }
        }

        stage('Build and Test') {
            steps {
                // Build the project and run tests
                bat 'mvn clean install'
            }
        }

        stage('Generate Allure Report') {
            steps {
                // Generate the Allure report
                bat 'mvn allure:serve'
            }
        }

        stage('Publish Allure Report') {
            steps {
                // Publish the Allure report
                allure includeProperties: false, results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            // Optionally archive artifacts or clean up
            archiveArtifacts artifacts: 'target/allure-results/**', allowEmptyArchive: true
        }
    }
}
