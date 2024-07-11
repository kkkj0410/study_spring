// @Component
// @Primary
// public class FixDiscountPolicy implements DiscountPolicy {
// }


// @Component
// public class RateDiscountPolicy implements DiscountPolicy{
// }

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
//->FixDisCountPolicy 호출
}
