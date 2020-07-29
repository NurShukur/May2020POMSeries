pipeline {
  agent any
  stages {
    stage('Build Dev') {
      parallel {
        stage('Build Dev') {
          steps {
            sh 'mvn clean install -DSkipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=dev'
          }
        }

      }
    }

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -DSkipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn test -Denv=qa'
          }
        }

      }
    }

    stage('Build Stage') {
      parallel {
        stage('Build Stage') {
          steps {
            sh 'mvn clean install -DSkipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=stage'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn test -Denv=stage'
          }
        }

        stage('edge') {
          steps {
            sh '''mvn test -Denv=stage
'''
          }
        }

      }
    }

    stage('Publish Reports') {
      steps {
        script {
          allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: '/allure-results']]
          ])
        }

      }
    }

  }
}