### <요약>
- Advice 순서 선택
- class 안에 class를 만들어서 Advice 순서를 지정함
- QnA)
    - 그냥 Advice 함수에다가 @Order지정해서 함수 순서를 만들면 안되냐?
    - 아래 같이 만들면 순서가 제대로 적용되지 않음
    - ⇒ 스프링 AOP는 객체 단위로 프록시를 구성하기 때문에 함수에다가 Order를 넣어봤자 의미 없음
        - (따로, 각 Advice 함수를 각 객체로 분리해서 순서를 적용해야함)
    - ex)

        @Order(1)
        @Around("hello.aop.order.aop.Pointcuts.allOrder()")
        public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[log] {}", joinPoint.getSignature());
            return joinPoint.proceed();
        }
        
        @Order(2)
        @Around("hello.aop.order.aop.Pointcuts.orderAndService()")
        public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable
        {
            try {
                log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
                Object result = joinPoint.proceed();
                log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
                return result;
            } catch (Exception e) {
                log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
                throw e;
            } finally {
                log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
            }
        }
