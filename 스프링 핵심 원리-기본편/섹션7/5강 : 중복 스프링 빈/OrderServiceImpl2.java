// @Component
// @Qualifier("fixDiscountPolicy")
// public class FixDiscountPolicy implements DiscountPolicy {
// }

// @Component
// @Qualifier("mainDiscountPolicy")
// public class RateDiscountPolicy implements DiscountPolicy{
// }

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

}
