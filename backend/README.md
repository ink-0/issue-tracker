# Back End

## 프로젝트 실행법

### Docker Desktop 을 꼬옥! 미리 실행한다.

### 환경변수를 설정한다.

```sh
export GITHUB_CLIENT_ID="02d3c6009c956f409399"
export GITHUB_CLIENT_SECRET="ask_to_pyro"
export GITHUB_IOS_CLIENT_ID="6cd127b711edc7a10a5c"
export GITHUB_IOS_CLIENT_SECRET="3dc13a8fb7474e085ec63c3b928d2bdf20f64a89"
export GITHUB_WEB_CLIENT_ID="2a42dd1b1e2aad1238e9"
export GITHUB_WEB_CLIENT_SECRET="c34678e8b0aaca11d7c2f53dfc46993bc0a29748"
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
