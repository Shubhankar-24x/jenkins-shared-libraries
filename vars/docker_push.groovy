stage("Docker: Image Push to DockerHub") {
    steps {
        script {
            withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]){
                echo "Logging into DockerHub"
                
                // Log in to DockerHub using the provided credentials
                sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
                echo "Login to DockerHub successful"
            }

            echo "Pushing image to Docker Hub"

            // Push the Docker image to DockerHub using the provided variables
            sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
            echo "Image pushed successfully to Docker Hub"
        }
    }
}
