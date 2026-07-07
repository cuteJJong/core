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

	// @Bean memverService -> new MemoryMemberRepository()
	// @Bean orderService -> new MemoryMemberRepository()

	// 예상
	// call AppConfig.memberService
	// call AppConfig.memberRepository
	// call AppConfig.memberRepository
	// call AppConfig.orderService
	// call AppConfig.memberRepository

	// 실행 결과
	//	call AppConfig.memberService
	//	call AppConfig.memberRepository
	//	call AppConfig.orderService

	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		// return new OrderServiceImpl(
		// 		memberRepository(),
		// 		discountPolicy());
		return null;
	}

	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy discountPolicy() {
		//return new FixDiscountPolicy();

		//할인 정책 변경
		return new RateDiscountPolicy();
	}

}
