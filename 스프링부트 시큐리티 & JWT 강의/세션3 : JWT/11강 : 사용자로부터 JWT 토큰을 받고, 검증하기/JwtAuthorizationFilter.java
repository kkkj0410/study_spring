import java.io.IOException;

//권한 인증 시에 필터링 되는 객체 만들기
//시큐리티가 filter를 가지고 있음
//그 필터 중, BasicAuthenticationFiler가 있음
// 권한 인증이 필요한 특정 주소 요청 시, 해당 필터를 거쳐감
// 만약, 권한 인증이 필요없는 주소는 이 필터 사용 X
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserRepository userRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;

    }

    //인증 권한 필요 시, 해당 함수를 거쳐감
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("인증이나 권한이 필요한 주소 요청 발생");
				
				//JWT 토큰의 헤더 이름은 Authorization
        String jwtHeader = request.getHeader("Authorization");
        System.out.println("jwtHeader : " + jwtHeader);

        //JWT 토큰 검증

        //JWT - header 검증
        if(jwtHeader == null || !jwtHeader.startsWith("Bearer")){
            System.out.println("JWT 검증 실패");
            chain.doFilter(request,response);
        }

        //헤더 value값에서 Bearer 없애기
        String jwtToken = request.getHeader("Authorization").replace("Bearer ", "");

        //JWT - 서명해서 username 가져오기
        String username = JWT.require(Algorithm.HMAC512("cos"))
                            .build()
                            .verify(jwtToken)
                            .getClaim("username")
                            .asString();

        System.out.println("JWT 토큰 Username 가져오기 : " + username);

        // 서명이 제대로 됐으면 값이 존재함
        if(username != null){
            User userEntity = userRepository.findByUsername(username);
            System.out.println("userEntity 생성" + userEntity);

            System.out.println("principalDetails 생성");
            PrincipalDetails principalDetails = new PrincipalDetails(userEntity);


            System.out.println("authentication 생성");
            // JWT 토큰 서명을 통해서 서명이 정상이면 Authentication 객체를 만들어준다.
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());

            System.out.println("JWT 접근 후, authentication 저장");
            //저장 공간
            //강제로 시큐리티의 세션에 접근하여 Authentication 객체 저장( => 해당 유저 저장)
            SecurityContextHolder.getContext().setAuthentication(authentication);

            chain.doFilter(request,response);

        }
    }
}
