
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        //해당 방식은 사용하면 안됨
        //String 끼리의 더하기 연산이 일어나므로, 연산에 대한 자원 낭비임
        log.trace("trace log=" + name);

        //해당 방식은 연산이 일어나지않음
        //이유는 trace가 출력 범위가 아닌 경우, name이 {}로 넘어가는(매개변수 전달) 과정이 취소됨. 따라서 연산X
        log.trace(" trace log={}", name);

        return "ok";
    }
}
