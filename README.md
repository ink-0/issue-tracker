# Issue Tracker 
GitHub의 이슈를 관리하는 서비스로 GiuHub로그인 후에 `이슈`,`마일스톤`,`프로젝트`를 관리할 수 있는 웹 서비스 입니다.    
[TypeScript ,Recoil ,SpringBoot, MySQL]
## 📌프로젝트 구현
![화면 기록 2021-07-01 오후 11 53 05 mov](https://user-images.githubusercontent.com/71919983/124317554-531cf380-dbb2-11eb-80a6-7f9fd20d1a2d.gif)

## 📌프로젝트 정보
### 프로젝트 진행 과정 블로그 정리
[🔗 Issue-Cracker -1부](https://rrecoder.tistory.com/153)  
[🔗 Issue-Cracker -2부](https://rrecoder.tistory.com/154)  
### 문제 해결과 개선 과정

|주제|링크|내용요약|
|------|---|---|
|문제&해결|[🔗고민과제들](https://github.com/ink-0/issue-tracker/wiki/%EB%AC%B8%EC%A0%9C%EC%A7%81%EB%A9%B4-&-%ED%95%B4%EA%B2%B0%EA%B3%BC%EC%A0%95)|문제상황들과 그 해결 과정을 위한 시도|
|개선|[🔗개선사항](https://github.com/ink-0/issue-tracker/wiki/%EA%B0%9C%EC%84%A0%EC%82%AC%ED%95%AD)|좋은 코드를 위한 리팩토링 과정|
|회고|[🔗프로젝트회고](https://github.com/ink-0/issue-tracker/wiki/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%9A%8C%EA%B3%A0)|프로젝트 회고와 배운점|
|협업|[🔗협업 과정](https://github.com/ink-0/issue-tracker/wiki/%ED%98%91%EC%97%85-%EB%B0%A9%EC%8B%9D%EA%B3%BC-%EA%B3%BC%EC%A0%95)|커뮤니케이션과 협업의 기록|

### 관련 링크
[🔗 팀 notion](https://www.notion.so/Taccon-s-24d13fbd0e6b4e7fbe4489b242f8147b) 

[🔗 팀 convention](https://github.com/ink-0/issue-tracker/wiki/Home-&-Rule) 

[🔗 FE API 요구사항](https://github.com/ink-0/issue-tracker/wiki/FE-API-%EA%B5%AC%EC%84%B1)  

[🔗 도메인 diagram](https://github.com/ink-0/issue-tracker/wiki/%ED%9A%8C%EC%9D%98-%EB%B0%8F-%EC%A0%95%EC%B1%85)

### 팀 구성 

|iOS|FE|BE|
|------|---|---|
|Neo|Raccoon|Pyro|
||Tami|Noeul|
  
## 📌파일 구조
[🔗 component 다이어그램](https://drive.google.com/file/d/1d5YJRCsRzQx0HZrN-AcuEdZPTpJe6vlz/view?usp=sharing)  
![Team13-issue-tracker diagram](https://user-images.githubusercontent.com/71919983/123673325-4aa77e80-d87b-11eb-9760-f447d0ba3391.png)

<details>
<summary>파일구조 이미지</summary>
<div markdown="1">
<img width="451" alt="스크린샷 2021-06-28 오후 5 59 35" src="https://user-images.githubusercontent.com/71919983/123609465-a43b8900-d83a-11eb-800a-9413b2d4062f.png">
</div>
</details>

기본적인 layout으로 구분하고 , 2회 이상 반복적으로 사용하는 요소는 component 디렉토리에 구분하여 구현

## 📌 기술 요구 사항
함수형 프로그래밍을 활용한 데이터 
- **recoil**을 활용한 상태관리
- **material UI**을 적극적으로 사용한 스타일 관리
- Fetch API 등의 비동기 상황 **에러 처리** 

