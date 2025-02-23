@Slf4j
public class ExecutionTest {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod(){
        log.info("helloMethod={}", helloMethod);
    }
    
    //출력
    //17:51:48.531 [Test worker] INFO hello.aop.pointcut.ExecutionTest -- helloMethod=public java.lang.String hello.aop.member.MemberServiceImpl.hello(java.lang.String)

}
