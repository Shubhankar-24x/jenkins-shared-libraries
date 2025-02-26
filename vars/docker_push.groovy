def call(String Project, String ImageTag, String DockerHubUser){
    
    withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]){
        echo "Logging to DockerHub"
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        echo "Login to Dockerhub Successfull"
        
    }
    echo "This is pushing image to Docker Hub"
    sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
    echo "Image pushed successfully to Docker Hub"
}
