@Slf4j
public class RealComponent implements Component{

    @Override
    public String operation(){
        log.info("RealComponent 실행");
        return "data";
    }
}
