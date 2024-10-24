@Configuration
public class CorsConfig {


    //cors : 내가 아닌 다른 URL에게 내 자원을 쓰도록 허용하는 것
    //아래 코드에서는 cors 제한을 아예 풀어버림
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답을 할 때, json을 JS에서 처리할 수 있게 할지를 설정
        config.addAllowedOrigin("*"); // 모든 ip에 응답을 허용
        config.addAllowedHeader("*"); // 모든 헤더에 응답 허용
        config.addAllowedMethod("*"); // 모든 post,get put, delete, patch 요청 허용
        source.registerCorsConfiguration("/api/**", config);
        return new CorsFilter(source);
    }
}
