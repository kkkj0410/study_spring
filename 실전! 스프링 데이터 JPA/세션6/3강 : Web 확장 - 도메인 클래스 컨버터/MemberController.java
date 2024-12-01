@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

		//members/123 -> id = 123 member 조회
    @GetMapping("members/{id}")
    public String findMember(@PathVariable("id") Long id){
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

		//해당 코드는 관련X
		//초기값으로 memberRepository에 member 넣는 역할
    @PostConstruct
    public void init(){
        memberRepository.save(new Member("userA"));
    }
}
