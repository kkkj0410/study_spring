### <요약>
- 실행할때마다 DB에 데이터를 미리 넣어놓으려 한다.
    - 검증하기 편할려고 만드는 것
- .yml 파일과 init 객체를 만들어서 해결 가능

- application.yml
    - (active에 있는 이름은 자유)

- initMember
    - 실행할 때마다, 해당 데이터들이 자동으로 DB에 들어감

QnA) 실제 실행과 테스트 실행에서 init을 분리하려면?
- test 폴더에서 resources/application.yml파일을 만든 다음에, active를 다른 이름으로 설정
    - 해당 active이름에 따른 init을 새로 구축
spring:
  profiles:
    active: test
