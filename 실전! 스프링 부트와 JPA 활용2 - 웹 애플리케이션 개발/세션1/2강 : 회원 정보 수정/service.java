@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    @Transactional
    public void update(Long id, String name){
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }

}
