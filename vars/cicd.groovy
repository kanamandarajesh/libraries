def newGit(String repo) {
   git "${repo}"
}

def newMaven() {
   sh 'mvn package'
}

def newDeploy(String jobname, String ip, String context) {
    deploy adapters: [
        tomcat7(
            credentialsId: '163a1995-8583-453d-8c5d-c57f0ae8bafe', 
            path: '', 
            url: "http://"${ip}":8080"
        )
    ], 
    contextPath: context, 
    war: "**/"${jobname}"/target/*.war"
}
