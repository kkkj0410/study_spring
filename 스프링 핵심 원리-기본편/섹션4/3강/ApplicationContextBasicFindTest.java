package hello.core.beenFind;

import hello.core.AppConfig;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hello.core.member.MemberService;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName()
    {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        System.out.println(memberService);
//        System.out.println(memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType()
    {
        MemberService memberService = ac.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2()
    {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈이름으로 조회X")
    void findBeanNameX(){
        //ac.getBean("XXX", MemberService.class);
        //없는 스피링 빈을 출력할 시, 에러가 남을 확인함
        //에러 이름은 NoSuchBeanDefinitionException(없는 스피링 빈 호출)
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("XXX", MemberService.class));
    }
}
