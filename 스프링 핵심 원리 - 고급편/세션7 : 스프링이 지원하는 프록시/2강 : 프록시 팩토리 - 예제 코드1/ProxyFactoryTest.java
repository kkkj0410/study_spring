@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용")
    void interfaceProxy(){
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save();

				//JDK 프록시 또는 CGLIB 프록시면 참
        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        //JDK 프록시면 참
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();
        //CGLIB 프록시면 참
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }
}
