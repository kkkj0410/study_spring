package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//상위 주소(클래스 내부에서 사용된 주소들은 아래의 주소를 먼저 가지고 거기에 덧붙임
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    //하위 주소
    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }


    @RequestMapping("")//해당 URL이 호출 될 시, 해당 메소드 호출
    public ModelAndView save(){
        List<Member> members = memberRepository.findAll();

        //ModelAndView -> URL에 사용될 ViewName, Controller의 실행결과 members 저장
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members",members);

        //ModelAndView에 대한 정보는 View에 전달됨
        //applicatoin.properties에서 주소의 시작, 끝점을 지정했으므로 해당 .jsp파일이 정상적으로 실행됨
        // ex) /WEB-INF/views/members.jsp
        return mv;
    }


    @RequestMapping("/save")
    public ModelAndView members(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member",member);

        return mv;
    }
}
