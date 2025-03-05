### <요약>

- @target
    - 부모 인스턴스도 포함
    - 즉, 자식 객체를 target으로 지정하면 부모 객체도 동시에 target 대상이 됨
- @within
    - 부모 인스턴스 포함X
    - 즉, 자식 객체를 within으로 지정하면 부모 객체는 within 대상X
- 주의
    - args, @args, @target 포인트컷 지시자는 적용 대상을 줄여줘야 한다
    - 이유
        - 예를 들어, @target은 객체의 인스턴스가 실행되는 시점에 적용 여부를 결정한다.
        - 즉, 객체 인스턴스가 실행되는 시점에, 프록시가 있어야 @target 적용 여부를 확인 가능(아래 예시에서는 atTarget함수를 넣기위한 프록시로 예를 들 수 있음)
            - (프록시 내에서 target의 적용 여부를 검증하기 때문에 프록시 필요)
        - 프록시가 만들어지는 시점은 스프링 컨테이너가 만들어지는 애플리케이션 로딩 시점
        - 즉, 프록시는 객체 인스턴스가 실행되는 시점까지 살아있어야 @target 적용 여부를 결정 가능
        - 따라서 @target에 포함되는 모든 대상은 프록시를 전부 다 만들게 됨
        - ⇒ 모든 스프링 빈에 프록시가 생성되는 문제를 막기 위해서 target 적용 범위를 최대한 줄여야함
    - 예시
        - execution을 통해 target의 적용 범위를 줄였음
          @Around("execution(* hello.aop..*(..)) && @target(hello.aop.member.annotation.ClassAop)")
          public Object atTarget(ProceedingJoinPoint joinPoint) throws Throwable {
              log.info("[@target] {}", joinPoint.getSignature());
              return joinPoint.proceed();
          }
