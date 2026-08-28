pipeline {
    agent any

    tools {
        maven 'Maven3'
    }
    triggers{
        pollSCM('H/2 * * * *')
    }

    environment {
        KOEL_EMAIL = credentials('KOEL_EMAIL')
        KOEL_PASSWORD = credentials('KOEL_PASSWORD')
        GRID_URL = 'http://selenium-hub:4444'
    }

    stages {
        stage('Test') {
            steps {
                sh '''
                    mvn test \
                      -DgridUrl=$GRID_URL \
                      -Dsurefire.suiteXmlFiles=TestNG-cross-browser.xml
                '''
            }
        }
    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'

        archiveArtifacts artifacts: 'reports/ExtentReport.html',
                         allowEmptyArchive: true

        archiveArtifacts artifacts: 'screenshots/**/*',
                         allowEmptyArchive: true
        }
    }
}