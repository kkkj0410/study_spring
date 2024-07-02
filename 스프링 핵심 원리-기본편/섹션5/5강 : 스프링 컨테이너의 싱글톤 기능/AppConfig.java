package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

		//@Bean memberService() -> new MemoryMemberRepository() 호출
		//(과정 : memberService -> new MemberServiceImpl() -> memberRepository() -> new new MemoryMemberRepository())
		
		//@Bean orderService() -> new MemoryMemberRepository() 호출
		
		//new MemoryMemberRepository는 2번 호출 됐으므로, MemoryMemberRepository는 객체 2개
		//=> 싱글톤 패턴은 파괴됐나?
		
    @Bean
    public MemberService memberService()
    {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService()
    {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy()
    {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
