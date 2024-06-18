package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args)
    {
				//Spring Bean으로 등록된 AppConfig 클래스를 가져옴
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //"memberService"-> AppConfig에 있는 함수명, MemberService.class->memberService의 return된 객체
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }

}
