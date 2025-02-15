def call(){
  echo "Scanning Files with Trivy"
  sh "trivy fs ."
}
