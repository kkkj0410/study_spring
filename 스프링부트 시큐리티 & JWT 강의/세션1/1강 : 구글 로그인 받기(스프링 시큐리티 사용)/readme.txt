### 구글 설정
1. 구글 API 라이브러리 접속
https://console.cloud.google.com/apis/library?hl=ko

2. 프로젝트 생성

3. 해당 프로젝트의 oAuth 동의 화면 만들기
- API 및 서비스 → OAuth 동의 화면 → 생성

4. 사용자 인증 정보 → OAuth 2.0 클라이언트 ID 만들기

5. 승인된 리디렉션 URI에서 해당 URI를 추가
- http://localhost:8080/login/oauth2/code/google
- 해당 URL을 통해, 스프링 시큐리티는 사용자 인증 정보를 검사함
- 따라서 없으면 에러가 남.

### 프로젝트 설정
1. OAuth2 Client 받기

2. properties.yml 파일 설정
- client_id, client_secret 값은 “구글 설정 → 4번” 창에서 만들어진 id, 비밀번호 쓰면됨

### 사용
1. 구글 로그인 창 URL 주소로 보내기(해당 주소는 임의로 바꿀 수 없음)
- <a href="/oauth2/authorization/google">구글 로그인</a>

2. 필터에 적용
