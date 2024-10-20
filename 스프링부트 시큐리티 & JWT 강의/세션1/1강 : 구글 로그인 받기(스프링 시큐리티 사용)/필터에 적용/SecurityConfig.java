@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터(해당 객체)가 스프링 필터체인에 등록됨

// securedEnabled = true : secured 어노테이션 활성화
// prePostEnabled = true : preAuthorize, postAuthorize 어노테이션 활성화
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig{

    //해당 메서드의 리턴되는 오브젝트를 IoC로 등록
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF 보호 비활성화
        http.csrf().disable()
                .authorizeHttpRequests(authorize -> authorize

                        //아래 3가지 경로는 필터링에 걸림
                        .requestMatchers("/user/**").authenticated() // /user는 인증만 되면 접속 허가

                        //MANAGER, ADMIN 직함을 가진 대상만 해당 URL 접속을 허용
                        .requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN") // /manager 경로는 MANAGER 또는 ADMIN 역할 필요
                        .requestMatchers("/admin/**").hasRole("ADMIN") // /admin 경로는 ADMIN 역할 필요

                        //위 3가지 경로 빼고는 접근 허용
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/loginForm") // 사용자 정의 로그인 페이지
                        .loginProcessingUrl("/login") // /login 주소 POST 호출 시, 시큐리티가 낚아채서 대신 로그인
                        .defaultSuccessUrl("/")

                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/loginForm") // 구글 로그인이 완료된 뒤의 후 처리가 필요.

                );

        return http.build(); // SecurityFilterChain 반환
    }

}
