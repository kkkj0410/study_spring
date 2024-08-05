package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//해당 어노테이션은 private final Logger log = LoggerFactory.getLogger(getClass());을 안쓰고 log 쓰는게 가능해짐
//lombok의 기능
//@Slf4j

//메소드에서 return할 시, 원래는 String 값이 viewResolver에게 반환됨
//하지만 @RestController는 String 값을 그대로 view로 띄움
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace(" trace log={}", name);
        log.debug(" debug log={}", name);
        log.info(" info log = {}", name);
        log.warn(" warn log = {}", name);
        log.error(" error log = {}", name);


        //해당 방식은 사용하면 안됨
        //String 끼리의 더하기 연산이 일어나므로, 연산에 대한 자원 낭비임
        log.trace("trace log=" + name);

        //해당 방식은 연산이 일어나지않음
        //이유는 trace가 출력 범위가 아닌 경우, name이 {}로 넘어가는(매개변수 전달) 과정이 취소됨. 따라서 연산X
        log.trace(" trace log={}", name);

        return "ok";
    }
}
