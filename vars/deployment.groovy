def newClone(String repo) {
    git "${git_url}"
}  
def newBuild() {
    sh 'mvn clean package fabric8:build'
}
def newDeploy(user, ip) {
    sh 'ssh -i StrictsshKey=no "${user}"@"${ip}" /root/kubernetes/kubectl apply -f deploy.yml'
}    


@Library(my_shared_library)_
pipeline
{
    agent any
    stages
    {
        stage('clone')
        {
            steps
            {
                script
                {
                    cicd.newClone("git_url")
                }
            }   
        }
        stage('build image')
        {
            steps
            {
                script
                {
                    cicd.newBuild()
                }    
            }   
        }
        stage('deploy')
        {
            steps
            {
                script
                {
                    cicd.newDeploy("root", "192.168.199.138")
                }   
            }   
        }    
    }
}    
