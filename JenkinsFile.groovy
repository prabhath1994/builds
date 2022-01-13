pipeline{
agent any

stages {
  stage('Stage1: Go to Root'){
  steps{
  script{
		try{
			timeout(time: 300, unit: 'SECONDS'){//change the conventional times 
			userInput = input(
			id: 'Proceed1' ,message: 'Go ahead with parameters', parameters:[
			[$class:'FileParameterDefinition',name: 'Upload File ', description:"This is the fileupload test",fileLocation:'/JenkinsData/workspace/FileUploadTest '	]
			]
			)
			}
			
		}catch(err){
			
			if("SYSTEM" == user.toString()){
				didTimeout = true
				echo "InputTime Out"
			}
		}
  
				}
			}
		}
	}

}
