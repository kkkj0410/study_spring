package hello.servlet.domain.member;

//동시성 문제가 고려되어 있지 않음(Map)
//실무에서는 ConcurrentHashMap, AtomicLong 사용 고려

import java.util.HashMap;
import java.util.*;

//싱글톤 패턴
public class MemberRepository {

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    //MemberRepository를 만드는 것이 불가능
    //getInstance()로만 MemberRepository를 사용하는 것이 가능
    //=> 싱글톤 패턴
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
