@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터(해당 객체)가 스프링 필터체인에 등록됨
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

                        // .requestMatchers("/user/**") : /user URL로 들어오는 대상을 지정
                        // .authenticated() : 인증 요청 -> UsernamePasswordAuthenticationFilter 객체에게 접근 권한 있는지 확인 요청
                        // 대상이 접근 권한이 없는 것이 판정되면 로그인 창으로 이동
                        .requestMatchers("/user/**").authenticated() // /user는 인증만 되면 접속 허가

                        //위 경로 빼고는 모든 URL 접근 허용
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
					                //로그인 창 정의(접근 권한이 없는 대상자는 로그인 창으로 이동함. 따라서 해당 창으로 이동)
                        .loginPage("/loginForm")
                        
                        // /login 주소로 post 요청 시, 시큐리티가 실행되게끔 요청
                        .loginProcessingUrl("/login") // /login 주소 POST 호출 시, 시큐리티가 낚아채서 대신 로그인
                        
                        // 로그인 성공 시, 이동하는 url 주소 지정
                        .defaultSuccessUrl("/")
                );

        return http.build(); // SecurityFilterChain 반환
    }
