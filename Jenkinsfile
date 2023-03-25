//FOR MAC SH
// pipeline {
//     agent any
//
//     tools {
//         // Install the Maven version configured as "M3" and add it to the path.
//         maven "Maven"
//         jdk "JDK17"
//     }
//
//     stages {
//         stage('Build') {
//             steps {
//                 // Get some code from a GitHub repository
//                 git branch: 'master', url: 'https://github.com/mlvncnxx/COMP367_MavenApp.git'
//
//                 // Run Maven on a Unix agent.
//                 //sh "mvn -Dmaven.test.failure.ignore=true clean package"
//
//                 // To run Maven on a Windows agent, use
//                  bat "mvn clean compile"
//             }
//         }
//     }
// }
//
// pipeline {
//     agent any
//
//     tools {
//         maven "Maven"
//         jdk "JDK17"
//         docker "Docker"
//     }
//
//     environment {
//         registry = "melanonuevo"
//         imageName = "comp367-maven"
//         imageTag = "1.0"
//     }
//
//     stages {
//         stage('Checkout') {
//             steps {
//                 git branch: 'master', url: 'https://github.com/mlvncnxx/COMP367_MavenApp.git'
//             }
//         }
//
//         stage('Build and Test') {
//             steps {
//                 sh "mvn clean package"
//             }
//         }
//
//         stage('Build Docker Image') {
//             steps {
//                 sh "docker build -t ${registry}/${imageName}:${imageTag} ."
//             }
//         }
//
//         stage("Docker login") {
//             steps {
//              script {
//
//                 withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
//                     sh "docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}"
//                 }
//              }
//             }
//         }
//
//         stage('Push Docker Image') {
//             steps {
//                 //withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
//                     //sh "docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}"
//                 //}
//                 sh "docker push ${registry}/${imageName}:${imageTag}"
//             }
//         }
//     }
// }


//FOR WINDOWS BAT
pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
        jdk "JDK17"
    }

    environment {
        registry = "melanonuevo"
        imageName = "mavenapp"
        imageTag = "1.0"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'master', url: 'https://github.com/mlvncnxx/COMP367_MavenApp.git'

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/mlvncnxx/COMP367_MavenApp.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                bat "mvn clean package"
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t ${registry}/${imageName}:${imageTag} ."
            }
        }

        stage("Docker login") {
            steps {
             script {

                withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                    bat "docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}"
                }
             }
            }
        }

        stage('Push Docker Image') {
            steps {
                bat "docker push ${registry}/${imageName}:${imageTag}"
            }
        }
    }
}

