def call(String Project, String ImageTag, String DockerHubUser){
    
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]){
        sh "docker login -u ${user} -p ${pass}"
        
    }
    echo "This is pushing image to Docker Hub"
    sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
    echo "Image pushed successfully to Docker Hub"
}
