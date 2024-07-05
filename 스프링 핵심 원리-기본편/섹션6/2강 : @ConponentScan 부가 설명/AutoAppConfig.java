package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //Scan 대상 정하기(hello.core.member -> member 패키지 탐색됨)
        //Default Scan은 해당 코드의 패키지를 대상으로 탐색 시작(package hello.core;-> hello.core 내부의 파일 전부 탐색)
        basePackages = "hello.core.member",
        
        //이전 AppConfig에 대한 스프링 빈 등록을 막는 역할(=>@Configuration에 대한 스프링 빈 등록을 막음)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
