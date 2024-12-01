@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("members2/{id}")
    public String findMember2(@PathVariable("id") Member member){
        return member.getUsername();
    }

		//해당 코드는 관련X
		//초기값으로 memberRepository에 member 넣는 역할
    @PostConstruct
    public void init(){
        memberRepository.save(new Member("userA"));
    }
}
