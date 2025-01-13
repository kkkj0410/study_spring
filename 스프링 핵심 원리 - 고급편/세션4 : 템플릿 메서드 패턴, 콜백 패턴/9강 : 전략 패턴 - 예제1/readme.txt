### <요약>
- 전략 패턴
    - 의미
        - 비즈니스 로직과 공통 로직 분리
        - (템플릿 패턴과 같은 의도를 가짐. 다만, 전략 패턴은 interface를 사용)

- 로그 추적기
    - 비즈니스 로직은 Strategy
        - (Strategy에 비즈니스 로직을 담고, execute함수를 실행하는 것이 목적)

- 테스트
    - 과정
        - Strategy → 비즈니스 로직
        - ContextV1에 Strategy 담기
        - ContextV1에서 execute 함수 실행
            - (로그 추적기가 동작하는 동시에, 비즈니스 로직 실행)
