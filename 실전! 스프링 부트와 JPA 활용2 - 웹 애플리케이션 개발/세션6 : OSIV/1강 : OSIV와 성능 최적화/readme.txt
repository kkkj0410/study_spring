- OSIV
    - Open Session In View
    - 사용자에게 View를 보낼때까지 DB 커넥션을 유지하는 기능
- 설명
    - JPA에는 영속성 컨텍스트가 존재
    - 영속성 컨텍스트가 DB와의 커넥션을 가짐
    - OSIV 기능은 사용자에게 View를 보여줄때까지 DB 커넥션을 유지하는 것

- OSIV
    - 장점
        - 지연로딩 처리 가능
            - Controller 계층에서 지연로딩된 객체의 값을 DB에서 가져온다고 하자.
            - 이 경우, OSIV 기능이 켜져있다면 에러없이 정상적으로 처리가능
    - 단점
        - DB 커넥션 개수 부족
            - Controller 계층에서 시간이 오래 걸리는 작업을 한다고 하자.
            - 그 경우, DB 커넥션이 필요하지도 않은데 DB 커넥션을 가지고 있을 수 있다.
            - 사용자가 많은 경우에는 DB 커넥션이 부족해지는 경우가 발생 할 수 있다.

- OSIV 기능 OFF
    - 설명
        - OSIV 기능을 끄면 어떻게 될까?
        - DB 커넥션이 Service 계층까지만 유지된다.

- OSIV 기능 OFF
    - 장점
        - DB 커넥션 개수가 부족할 일이 별로 없어짐
    - 단점
        - Controller에서 지연로딩된 객체 가져오기 불가능(DB가 없으니 가져올 수가 없음)

### 1. OSIV off 문제 해결

- 방법
    - Controller와 Service 계층 사이에 지연로딩 객체를 불러오는 쿼리 서비스를 구현한다
- 예시(contoller.java)
    - Controller의 함수를 그대로 긁어와서 QueryService에 가져옴
    - Controller는 service 대신, QueryService에 있는 값을 가져와서 사용
    - ⇒ 이렇게 하면 OSIV 없이, 지연 로딩된 객체를 가져오는게 해결됨
- 하지만 QueryService를 만들면 코드가 복잡해져버림

### 2. OSIV → ON vs OFF
- OSIV는 켜야하나 말아야하나?
    - OFF
        - 사용자가 많은 서비스의 경우 OSIV 기능을 OFF
    - ON
        - 사용자가 많지 않은 경우 OSIV 기능 ON
