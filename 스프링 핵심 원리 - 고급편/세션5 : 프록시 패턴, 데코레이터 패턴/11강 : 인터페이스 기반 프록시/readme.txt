### <요약>
- 실제 비즈니스 로직에 프록시(로그 추적기 기능)를 붙이려고 한다
    - 또한, 비즈니스 로직 객체를 전혀 건들이지 않고 로그 추적이 가능해야한다
- 방법
    - 스프링 빈 호출 시, 프록시를 호출하게 한다
    - 즉, 사용자 → 프록시 → 비즈니스 로직 객체 순으로 호출되게 만든다.
- 구조
    - 비즈니스 로직
        - 각 객체는 상단의 Interface 객체에 의존함
            - (controllerImpl → controller 인터페이스 의존)


-----

- Controller 프록시(OrderControllerInterfaceProxy.java)
    - Controller에 로그 추적기 달기
    - 로그를 출력함과 동시에, Controller 객체를 실행함

- factory(InterfaceProxyConfig.java)
    - 스프링 빈 등록
    - 실제 스프링 빈은 프록시 객체로 반환한다.
    - 즉, 사용자는 프록시 객체를 스프링 빈으로 사용가능하다.
    - 사용자 → 프록시 → 비즈니스 로직 객체 순으로 호출된다.
