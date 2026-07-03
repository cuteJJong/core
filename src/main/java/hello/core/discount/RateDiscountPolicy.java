package hello.core.discount;

import org.springframework.stereotype.Component;

import hello.core.member.Grade;
import hello.core.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountRate = 10;

    @Override
    public int discount(Member member, int discountAmount) {
        if (member.getGrade() == Grade.VIP) {
            return discountAmount * discountRate / 100;
        } else {
            return 0;
        }
    }
}
