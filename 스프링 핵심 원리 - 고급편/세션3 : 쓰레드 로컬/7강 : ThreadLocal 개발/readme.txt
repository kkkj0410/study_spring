### <요약>
- ThreadLocal을 실제 로그추적기에 적용
- 주의
    - 사용이 끝난 쓰레드로컬은 .remove를 통해 해당 공간을 없애줘야함
        - = null 이런 식으로 해줘도 쓰레드가 사용한 공간이 남아있기 때문에 없애야함

- 로그추적기
    - 멤버 변수 traceIdHolder에 ThreadLocal 적용
