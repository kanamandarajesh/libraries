def newGit(String repo) {
   git "${repo}"
}

def newMaven() {
   sh 'mvn package'
}

def newDeploy() {
deploy adapters: [tomcat7(credentialsId: '163a1995-8583-453d-8c5d-c57f0ae8bafe', path: '', url: 'http://192.168.199.137:8080')], contextPath: 'TestApp', war: '**/*.war'
}    
