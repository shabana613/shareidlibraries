def call(ips,user,credId){
  sshagent([credId]) { 
 //   ips.each {
 //     echo "Deploying on ${it}"
      sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ips}:/opt/tomcat8/webapps/app.war"
      sh "ssh ${user}@${ips} /opt/tomcat8/bin/shutdown.sh"
      sh "ssh ${user}@${ips} /opt/tomcat8/bin/startup.sh"
    }
  } 
//}
