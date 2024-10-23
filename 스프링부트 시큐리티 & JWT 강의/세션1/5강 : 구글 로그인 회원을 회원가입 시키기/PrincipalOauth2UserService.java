
//DefaultOAuth2UserService를 상속받을 시, OAuth2 로그인 요청을 받을때마다 해당 객체 실행됨
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    @Lazy
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    //구글로부터 받은 userRequest 데이터 후처리 함수
    //
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        //registrationId로 어떤 OAuth로 로그인 했는지 확인 가능
        System.out.println("userRequest : " + userRequest.getClientRegistration());
        System.out.println("getAccessToken : " + userRequest.getAccessToken().getTokenValue());

        OAuth2User oauth2User = super.loadUser(userRequest);

        System.out.println("getAttributes : " + oauth2User.getAttributes());

        String provider = userRequest.getClientRegistration().getClientId(); // = google
        String providerId = oauth2User.getAttribute("sub");
        String username = provider + "_" + providerId; // google_123123123
        String password = bCryptPasswordEncoder.encode("aaa");
        String email = oauth2User.getAttribute("email");
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);

        if(userEntity == null){

            System.out.println("구글 로그인 최초");
            userEntity = User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        }else{
            System.out.println("구글 로그인 중복");
        }

        return new PrincipalDetails(userEntity, oauth2User.getAttributes());
    }
}
