### <요약>

- JDK 동적 프록시를 실제 비즈니스 로직 객체에 적용하려고 한다.
- 방법
    - 스프링 빈으로 JDK 동적 프록시를 등록한다
- 문제
    - 비즈니스 로직 객체의 전체 함수가 로그 출력이 된다
        - (로그가 출력되면 안되는 함수까지 출력됨)
          @GetMapping("/v2/no-log")
          public String noLog(){
              return "ok";
          }
