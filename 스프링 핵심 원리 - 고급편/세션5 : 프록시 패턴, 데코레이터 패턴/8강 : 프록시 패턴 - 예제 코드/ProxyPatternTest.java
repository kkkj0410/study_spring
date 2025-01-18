public class ProxyPatternTest {

    @Test
    void cacheProxyTest(){
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheproxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheproxy);

        client.execute();
        client.execute();
        client.execute();
        
        // <출력>
        // 프록시 호출
        // 실제 객체 호출
        // 프록시 호출
        // 프록시 호출
    }
}
