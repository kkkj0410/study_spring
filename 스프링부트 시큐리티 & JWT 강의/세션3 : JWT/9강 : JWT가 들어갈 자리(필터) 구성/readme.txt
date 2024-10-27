UsernamePasswordAuthenticationFilter?

- /login 경로에 대한 POST 요청을 받을 시, 실행되는 객체
- 따라서 JWT 인증 시도 시, 해당 필터링에서 진행될 예정?

작동원리
- AuthenticationConfiguration을 선언(해당 객체는 AuthenticationManager를 만드는 기능)
- AuthenticationConfiguration로 AuthenticationManager를 생성
- AuthenticationManager를 JwtAuthenticationFilter 객체에 전달
- JwtAuthenticationFilter 객체는 AuthenticationManager에 POST 요청으로 오는 사용자 정보를 전달
- AuthenticationManager는 해당 시큐리티 내에 사용자 정보가 있는 지 확인 후, 있으면 해당 사용자 정보를 return

QnA)
- AuthenticationManager에는 AuthenticatoinProvider가 존재한다. AuthenticatoinProvider는 사용자의 입력 객체(User, Member 등)에 따라 해당 유형에 맞게 만들어진다. 하지만  User에 대한 AuthenticatoinProvider를 만들지 않았는데도 불구하고, 정상적으로 코드가 실행된다. User에 대한 AuthenticatoinProvider는 언제 만들어지는가?
    - AuthenticatoinProvider는  UserDetailsService, PasswordEncoder 두 타입의 객체가 스프링 빈에 존재할 시, 자동으로 만들어진다. 따라서, 해당 유형들을 스프링빈에 등록했으므로, User 객체에 대한 AuthenticatoinProvider는 이미 생성되었다.
