#!groovy
pipeline {
    agent none
   stages {     
    stage('Maven Install') {
      agent {         
       docker {          
         image 'maven:3.5.0'         
     }       
  }       
  steps {
       sh "docker ps -a"
       sh "mvn clean install -Dmaven.test.skip=true"
       }
     }
   }
 }
