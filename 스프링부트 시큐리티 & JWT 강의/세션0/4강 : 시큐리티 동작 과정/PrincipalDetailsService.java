// UsernamePasswordAuthenticationFilter는 UserDetailService 함수에게 사용자 정보 열람을 요청했다.
// 따라서 UsernamePasswordAuthenticationFilter 실행 시, UserDetailService 상속받은 객체가 실행됨
// UserDetailsService를 상속받은 객체는 강제로 loadUserByUsername 함수를 실행시킴
// 해당 loadUserByUsername함수에서 userEntity(아래 코드 참조)라는 타입으로 UsernamePasswordAuthenticationFilter에게 사용자 정보를 반환함
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    //직접 만든 함수 (아래 코드 참고)
    private UserRepository userRepository;

    //시큐리티 session(내부 Authentication(내부 UserDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);

        if (userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
