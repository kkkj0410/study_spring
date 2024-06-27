package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest()
    {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //동일한 객체를 반환
        System.out.println("memberSerivice1 = " + singletonService1);
        System.out.println("memberSerivice2 = " + singletonService2);


        assertThat(singletonService1).isSameAs(singletonService2);
        //isSameAs 참조 비교 (==)
        //isEqualTo 값 비교
    }
}
