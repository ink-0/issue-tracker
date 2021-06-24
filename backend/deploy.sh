# 출처: https://www.notion.so/cc778488e5524e1999a1bcf0c19f0006

KEY_PATH=/Users/g/issue-0624.pem
AWS_PATH=ubuntu@3.37.211.5
JAR_FILE=issuetracker.jar

cd ./server
./gradlew build -x test

# scp 명령어로 jar 파일 전송
ssh -i $KEY_PATH $AWS_PATH "rm -rf ~/$JAR_FILE"
scp -i $KEY_PATH ./build/libs/$JAR_FILE $AWS_PATH:~

# 백그라운드로 BE server 배포
TOMCAT_PROCESS=$(ssh -i $KEY_PATH $AWS_PATH "lsof -t -i tcp:8080")
ssh -i $KEY_PATH $AWS_PATH "kill -9 $TOMCAT_PROCESS"
ssh -i $KEY_PATH $AWS_PATH "java -jar ~/$JAR_FILE >> spring-log.txt 2>&1 &"
