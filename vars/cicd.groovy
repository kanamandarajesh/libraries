def newGit(String repo) {
    git "${repo}"
}

def newMaven() {
    sh 'mvn package'
}

def newDeploy(ip,app) {
    deploy adapters: [tomcat7(credentialsId: '163a1995-8583-453d-8c5d-c57f0ae8bafe', path: '', url: "${ip}")], contextPath: "${app}", war: '**/*.war'
}
def runSelenium(jobname) {
    sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
