@Slf4j
public class AImpl implements AInterface{

    @Override
    public String call(){
        log.info("A 호출");
        return "a";
    }
}
