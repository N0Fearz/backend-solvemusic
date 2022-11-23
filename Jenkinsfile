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
    stage("SonarQube status gate"){
      timeout(time: 5, unit: 'MINUTES') {
        def qualitygate = waitForQualityGate()
        if (qualitygate.status != "OK") {
        error "Pipeline aborted due to quality gate coverage failure."
        }
      }
    }
  }
}
