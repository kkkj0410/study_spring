package hello.servlet.web.servletmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller//스프링 빈 등록
public class SpringMemberListControllerV1{

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")//해당 URL이 호출 될 시, 해당 메소드 호출
    public ModelAndView process(){
        List<Member> members = memberRepository.findAll();

        //ModelAndView -> URL에 사용될 ViewName, Controller의 실행결과 members 저장
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members",members);

        //ModelAndView에 대한 정보는 View에 전달됨
        //applicatoin.properties에서 주소의 시작, 끝점을 지정했으므로 해당 .jsp파일이 정상적으로 실행됨
        // ex) /WEB-INF/views/members.jsp
        return mv;
    }
}
