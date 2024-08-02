package hello.servlet.web.servletmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//스프링 빈 등록
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")//해당 URL이 호출 될 시, 해당 메소드 호출
    public ModelAndView process() {
    
        //ModelAndView에 대한 정보는 View에 전달됨
        //applicatoin.properties에서 주소의 시작, 끝점을 지정했으므로 해당 .jsp파일이 정상적으로 실행됨
        // ex) /WEB-INF/views/new-form.jsp
        return new ModelAndView("new-form");
    }

}
