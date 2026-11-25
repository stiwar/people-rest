pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        git url: 'https://github.com/stiwar/people-rest.git',
            branch: 'feature/jenkinsfile'
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
  }
}