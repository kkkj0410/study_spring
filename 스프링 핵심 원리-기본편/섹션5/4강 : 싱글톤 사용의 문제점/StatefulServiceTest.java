package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadA : A 사용자 10000원 주문
        statefulService2.order("userA", 20000);

        //ThreadA : 사용자 A 주문 금액 조회
        int price = statefulService1.getPrice();
        //10000 출력해야하지만 20000 출력
        //A 사용자, B 사용자가 같은 객체를 공유하기 때문에, 중간에 B 사용자가 요청을 내리면 A 사용자의 요청에 덧씌워짐.
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
