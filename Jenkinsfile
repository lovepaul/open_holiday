pipeline {
    agent any

    stages {
        stage('拉取git代码') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'gitee-password', url: 'https://gitee.com/love521521/open-holiday.git']]])
            }
        }

        stage('mvn 编译') {
            steps {
                sh '/var/jenkins_home/maven/apache-maven-3.8.6/bin/mvn clean package -DskipTests'
            }
        }

        stage('docker 打包') {
            steps {
                sh '''  mv target/*.jar docker/
                        docker build -t registry.cn-shanghai.aliyuncs.com/lensman/open-holiday:$branch docker/
                        docker image prune -f
                        docker login --username=15942685465 registry.cn-shanghai.aliyuncs.com -p wj13372877826
                        docker push registry.cn-shanghai.aliyuncs.com/lensman/open-holiday:$branch'''
            }
        }

        stage('通知服务器运行') {
            steps {
                sshPublisher(publishers: [sshPublisherDesc(configName: 'ali-cloud', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'depl.sh open-holiday $branch 8083 8083', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}
