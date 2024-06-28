package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    //스프링 컨테이너의 호출할때마다 같은 객체를 호출하는지 확인
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer()
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회 : 호출할 때 마다 객체를 생성한다
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2. 조회 : 호출할 때 마다 객체를 생성한다
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


        //참조값이 같은 지를 확인(=1, 2가 서로 같은 객체를 생성하는지 확인)
        System.out.println("memberSerivice1 = " + memberService1);
        System.out.println("memberSerivice2 = " + memberService2);

        //memberService == memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }


}
