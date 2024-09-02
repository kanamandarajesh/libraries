def newGit(repo)
{
   git "${repo}"
}
def newMaven()
{
   sh 'mvn package'
}   
def newDeploy()
{
   sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war root@${ip}:/var/lib/tomcat/webapps/${context}.war"    
}   
