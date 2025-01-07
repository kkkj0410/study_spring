### <요약>

- 이전 강의의 로그 추적기는 동시성 문제가 발생한다.
    - 이유
        - 로그 추적기를 싱글톤 객체로 사용했다.
        - 따라서, 여러 고객이 들어왔을 때 1개의 로그 추적기로 작동한다.
        - 즉, 여러 명의 고객에 대해서 한 명의 고객이 들어온 것처럼 로그 추적기가 작동한다.

※ 동시성 문제

- 다중 스레드 구조에서 프로그램이 예상과 다르게 움직이는 것

- 예시
    - /v3/request로 GET 요청을 한 번에 여러번 했다
    - 로그 상태
        - ([nio-8080-exec-5] : 5는 스레드 번호를 나타낸다)
        - 각 스레드에 따라 독립적으로 로그 추적기가 동작해야한다.
        - 하지만 스레드와 상관없이 로그추적기가 연결되어있는 것을 확인할 수 있다.

2024-11-21T20:29:16.594+09:00  INFO 6308 --- [advanced] [nio-8080-exec-5] h.advanced.trace.logtrace.FieldLogTrace  : [b98ac38a] | | |<--OrderController.request() time=1017ms
2024-11-21T20:29:16.828+09:00  INFO 6308 --- [advanced] [nio-8080-exec-7] h.advanced.trace.logtrace.FieldLogTrace  : [b98ac38a] | | | | | | | |<--OrderRepository.save() time=1004ms
2024-11-21T20:29:16.828+09:00  INFO 6308 --- [advanced] [nio-8080-exec-7] h.advanced.trace.logtrace.FieldLogTrace  : [b98ac38a] | | | | | | |<--OrderService.orderItem() time=1004ms
2024-11-21T20:29:16.828+09:00  INFO 6308 --- [advanced] [nio-8080-exec-7] h.advanced.trace.logtrace.FieldLogTrace  : [b98ac38a] | | | | | |<--OrderController.request() time=1004ms
2024-11-21T20:29:17.025+09:00  INFO 6308 --- [advanced] [nio-8080-exec-2] h.advanced.trace.logtrace.FieldLogTrace  : [b98ac38a] | | | | | | | | | | |<--OrderRepository.save() time=1007ms
2024-11-21T20:29:17.025+09:00  INFO 6308 --- [advanced] [nio-8080-exec-2] h.advanced.trace.logtrace.FieldLogTrace  : [b98ac38a] | | | | | | | | | |<--OrderService.orderItem() time=1007ms
2024-11-21T20:29:17.025+09:00  INFO 6308 --- [advanced] [nio-8080-exec-2] h.advanced.trace.logtrace.FieldLogTrace  : [b98ac38a] | | | | | | | | |<--OrderController.request() time=1007ms
