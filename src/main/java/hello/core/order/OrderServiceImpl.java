package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;

	/*
	* OCP, DIP 위반 -> 구현체를 의존하고 있음
	* */
	//private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	//private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

	private final DiscountPolicy discountPolicy;

	// 수정자(setter) 주입
//	 private MemberRepository memberRepository;
// 	 private DiscountPolicy discountPolicy;

//	@Autowired(required = false)
//	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//		this.discountPolicy = discountPolicy;
//	}

//  @Autowired
//	public void setMemberRepository(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}

	// 필드 주입
	// 권장하지 않음
//	 @Autowired private MemberRepository memberRepository;
// 	 @Autowired private DiscountPolicy discountPolicy;

	//일반 메서드 주입
//	@Autowired
//	public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//		this.memberRepository = memberRepository;
//		this.discountPolicy = discountPolicy;
//	}

	// 생성자 주입
	// 생성자가 1개이면 @Autowired 생략 가능
	//@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		System.out.println("memberRepository = " + memberRepository);
		System.out.println("discountPolicy = " + discountPolicy);
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	//테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
