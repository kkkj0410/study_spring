package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest()
    {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);

        //client.connect();
        
        //ac.close()는 ac를 닫는 기능
        //ac가 ApplicationContext을 자료형으로 가질 시, 지원하지 않는 기능임.
        //그래서 ConfigurableApplicationContext ac로 선언하여 ac.close() 기능 사용
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig
    {
        @Bean
        public NetworkClient networkClient()
        {
		        //스프링 빈에 들어갈 객체 생성
            NetworkClient networkClient = new NetworkClient();
            
            //생성된 객체의 정보 수정
            networkClient.setUrl("http://hello-spring.dev");

            return networkClient;
        }
    }
}
