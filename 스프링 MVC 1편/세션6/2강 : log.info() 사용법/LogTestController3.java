
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){

        log.info(" info log = {}", name);
 

        return "ok";
    }
}
