@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /*
    @return null이면 로그인 실패
     */

    public Member login(String loginId, String password){
        //Optional 타입으로 Member 받기
        return memberRepository.findById(loginId)
                //password가 동일하면 true
                        .filter(m -> m.getPassword().equals(password))
                //아니면 null
                                .orElse(null);
    }

}
