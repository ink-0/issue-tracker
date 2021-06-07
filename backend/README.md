# Back End

## 프로젝트 실행법

### Docker Desktop 을 꼬옥! 미리 실행한다.

### 환경변수를 설정한다.

```sh
export GITHUB_CLIENT_ID="02d3c6009c956f409399"
export GITHUB_CLIENT_SECRET="파이로에게 문의"
export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:12345/pyrodb?autoReconnect=true&useUnicode=true&characterEncoding=UTF8&serverTimeZone=Asia/Seoul"
export SPRING_DATASOURCE_USERNAME="pyro"
export SPRING_DATASOURCE_PASSWORD="pyro1234"
export SPRING_REDIS_HOST="localhost"
export SPRING_REDIS_PORT="6379"
export SPRING_REDIS_PASSWORD="redis1234"
```

### backend/start.sh 스크립트를 실행한다.

backend 디렉토리로 이동해서, start.sh 를 실행한다.

```
cd ./backend
sh ./start.sh
```
