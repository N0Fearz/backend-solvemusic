pipeline {
  agent none
tools { 
  maven 'Maven 3.8'
  jdk 'Java17'
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
    stage("Quality Gate") {
      steps {
       timeout(time: 1, unit: 'HOURS') {
            waitForQualityGate abortPipeline: true
         }
       }
     }
  }
}
