// 스프링 시큐리티 -> UsernamePasswordAuthenticationFilter 기능
// /login 요청해서 username, password 전송하면 (post)

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // /login 요청을 하면 로그인 시도를 위해 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
        System.out.println("JwtAuthenticationFilter : 로그인 시도 중");

        // 1. username, password 받음
        try{
//            BufferedReader br = request.getReader();
//            String input = null;
//            while( (input = br.readLine()) != null){
//                System.out.println(input);
//            }

            //JSON 형식으로 데이터 받기
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);
            System.out.println(user);

            //토큰 제작
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            System.out.println("token : " + authenticationToken);

            //PrincipalDetailsService의 loadUserByUsername 함수가 실행됨
            //시큐리티에 해당 로그인 회원이 존재한다면, authentication은 해당 회원 데이터를 가져옴
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            System.out.println("----------------");
            PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();

            System.out.println(principalDetails);
            System.out.println(principalDetails.getUser().getUsername());

            return authentication;
        } catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("=========================");


        // 2. authenticationManager로 로그인 시도를 할 시, PrincipalDetailsService 호출
        // 3. PrincipalDetails를 세션에 담고 JWT 토큰을 만들면 된다.
        return null;
    }


    //JWT 토큰을 만들 함수
    //attemptAuthentication 함수 실행 후, 인증이 정상적으로 되었으면 해당 함수 실행됨
    //JWT 토큰을 만들어서 request 요청한 사용자에게 JWT 토큰을 response 해주면 됨.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();
        System.out.println("JWT 토큰 생성 시작");
        //Hash 암호 방식
        String jwtToken = JWT.create()
                .withSubject("cos토큰")
                //만료 시간(System.currentTimeMillis() = 현재 시간)
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000*30)))

                //JWT - Payload에 넣는 값
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("username", principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512("cos"));

        System.out.println("JWT 토큰 보내기");
        response.addHeader("Authorization", "Bearer " + jwtToken);
    }
}
