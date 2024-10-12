@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean loginCheckFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginCheckFilter());
        //체크 필터를 1번째 순위로 실행
        filterRegistrationBean.setOrder(1);
        // /* : /로 넘어오는 모든 URL에 대해서 필터 적용
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

}
