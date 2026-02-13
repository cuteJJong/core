package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class PixDiscountPolicy implements DiscountPolicy {

	private int discountFixAmount = 1000;    //1000원 할인

	@Override
	public int discount(Member member, int discountAmount) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
}
