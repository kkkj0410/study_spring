
@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터(해당 객체)가 스프링 필터체인에 등록됨

// securedEnabled = true : secured 어노테이션 활성화
// prePostEnabled = true : preAuthorize, postAuthorize 어노테이션 활성화
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig{

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // CSRF 보호 비활성화
        http.csrf().disable()
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/loginForm")
                        //사용자 로그인 후 처리 과정
                        .userInfoEndpoint(userInfo->
                                userInfo.userService(principalOauth2UserService))

                );

        return http.build(); // SecurityFilterChain 반환
    }

}
