package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	// 생성자 주입
	//    public MemberService memberService() {
	//        return new MemberServiceImpl(new MemoryMemberRepository());
	//    }
	//
	//    public OrderService orderService() {
	//        return new OrderServiceImpl(
	//                new MemoryMemberRepository(),
	//                new FixDiscountPolicy());
	//    }

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(
				memberRepository(),
				discountPolicy());
	}

	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy();

		//할인 정책 변경
		return new RateDiscountPolicy();
	}

}
