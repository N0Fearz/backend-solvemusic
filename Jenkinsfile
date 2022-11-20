pipeline {
  agent none
tools {
    maven 'maven-3.6.3' 
  }
  stages {
    stage("build & SonarQube analysis") {
      agent any
      steps {
        withSonarQubeEnv(installationName: 'SonarQube') {
          sh "mvn clean verify sonar:sonar -Dsonar.projectKey=N0Fearz_backend-solvemusic_AYSLX2e3hvql3WqieHLe"
        }
      }
    }
  }
}
