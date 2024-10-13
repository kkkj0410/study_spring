@Override
public void addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(new LogInterceptor())
            .order(1)
            // /** : 서블릿 필터의 /*과 같음 (/을 가진 대상 전체 조회)
            .addPathPatterns("/**")
            //해당 url은 실행에서 제외한다.
            .excludePathPatterns("/css/**", "/*.ico", "/*.ico", "/error");
}
