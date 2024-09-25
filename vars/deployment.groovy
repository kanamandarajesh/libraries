def newClone(string repo) {
    git ${git_url}
}  
def newBuild() {
    sh 'mvn clean package fabric8:build'
}
def newDeploy () {
    sh 'kubectl apply -f deploy.yml'
}    
