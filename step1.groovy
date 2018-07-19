pipeline {
    agent any
    parameters {
        string(name: 'job_id', defaultValue: 'xxxxxxx', description: 'job id')
    }
//    environment {
//        job_id = 'xxxxxxxx'
//    }
    stages {
        stage('Build') {
            steps {
                echo 'qopper pr1 Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'qopper pr1 Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'qopper pr1 Deploying....'
            }
        }
        stage('Next Job') {
            steps {
                build job: 'test_multibranch2/master',
                        parameters: [
                            [
                                    $class: 'StringParameterValue',
                                    name: 'job_id',
                                    value: params.job_id,
                            ]
                        ],
                        propagate: false

            }
        }
    }
}
