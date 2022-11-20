pipeline {
  agent none
  stages {
    stage("build & SonarQube analysis") {
      agent any
      steps {
        withSonarQubeEnv(installationName: 'SonarQube') {
          sh "./mvnw clean verify sonar:sonar -Dsonar.projectKey=N0Fearz_backend-solvemusic_AYSLX2e3hvql3WqieHLe"
        }
      }
    }
  }
}
