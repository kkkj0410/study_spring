
@Slf4j
public class CacheProxy implements Subject{

    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation(){
        log.info("프록시 호출");
        if(cacheValue == null){
		        //서버에서 호출된 값을 프록시에 저장
            cacheValue = target.operation();
        }
        return null;
    }
}
