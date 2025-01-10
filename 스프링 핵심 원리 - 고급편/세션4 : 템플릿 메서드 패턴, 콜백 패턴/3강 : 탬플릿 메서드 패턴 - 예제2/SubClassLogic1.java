@Slf4j
public class SubClassLogic1  extends AbstractTemplate {

    @Override
    protected void call(){
        log.info("비지니스 로직1 실행");
    }
}
