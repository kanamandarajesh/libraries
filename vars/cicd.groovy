def newGit(String repo) {
   git "${repo}"
}

def newMaven() {
   sh 'mvn package'
}

def newDeploy(String jobname, String ip, String context) {
    sh "scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war root@${ip}:/var/lib/tomcat/webapps/${context}.war"
}    
