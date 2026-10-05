stage('Build') {
    steps {
        bat 'mvn clean package -DskipTests'
    }
}

stage('Run Application') {
    steps {
        bat 'start /B java -jar target\\demo-0.0.1-SNAPSHOT.jar > application.log 2>&1'
    }
}