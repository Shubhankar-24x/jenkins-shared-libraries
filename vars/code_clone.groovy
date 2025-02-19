def call(String GitUrl, String GitBranch){
  echo " code cloning started"
  git url: "${GitUrl}", branch: "${GitBranch}"
  echo "Code cloning successfull"
}
