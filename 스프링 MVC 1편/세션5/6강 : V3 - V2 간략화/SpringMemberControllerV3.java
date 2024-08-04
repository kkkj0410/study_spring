package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//상위 주소
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    //method = RequestMethod.GET => GET방식의 요청만 받겠다(POST 등의 요청은 받지 않는다는 것)
    //@RequestMapping(value = "/new-form", method = RequestMethod.GET)
    //아래 코드는 위 코드를 간략화한 것
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }


    //@RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            //post받은 내용을 매개변수로 전달
            @RequestParam("username") String username,

            //post받은 내용은 전부 String이지만, 스프링이 알아서 int형으로 바꿔줌
            @RequestParam("age") int age,

            //.jsp에 값을 전달하기 위해서 addAttribute를 사용했었다.
            //model은 addAttribute를 사용하기 위해서 존재한다.
            Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member",member);
        return "save-result";
    }


    //@RequestMapping(method = RequestMethod.GET)//해당 URL이 호출 될 시, 해당 메소드 호출
    @GetMapping
    public String members(Model model){
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members",members);

        return "members";
    }
}
