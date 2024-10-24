@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsFilter corsFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // CSRF 보호 비활성화
        http.csrf().disable()

                //세션 X
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilter(corsFilter)
                .authorizeHttpRequests(authorize -> authorize
                        // 해당 URL은 USER, MANAGER, ADMIN 중 1개의 권한을 가져야 접속 가능
                        .requestMatchers("/api/v1/user/**").hasAnyRole("USER", "MANAGER", "ADMIN")

                        .requestMatchers("/api/v1/manager/**").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/api/v1/admin/**").hasAnyRole("ADMIN")

                        //위의 조건 외에는 모든 URL 접근 허용
                        .anyRequest().permitAll()
                )

                //개발자가 정의한 로그인 폼 사용X
                .formLogin(form -> form
                        .disable()
                )
                
                //시큐리티가 가진 기본 보안 기능 비활성화(대신 JWT 쓸거임)
                .httpBasic(httpBasic -> httpBasic
                        .disable()
                );


        return http.build(); // SecurityFilterChain 반환
    }
}
