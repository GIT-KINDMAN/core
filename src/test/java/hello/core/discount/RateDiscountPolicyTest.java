package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        RateDiscountPolicy discountPolicy = this.discountPolicy;
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000); // price가 10000이면, 10% 깎았을 때 discount 값이 1000이어야 하니까
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);
        //when
        RateDiscountPolicy discountPolicy = this.discountPolicy;
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0); // price가 10000이면, 10% 깎았을 때 discount 값이 1000이어야 하니까
    }


}