@Slf4j
@Aspect
public class AspectV1 {

    //해당 함수를 실행시킬 폴더 지정
    @Around("execution(* hello.aop.order..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[log] {}", joinPoint.getSignature());

        return joinPoint.proceed();
    }
}
