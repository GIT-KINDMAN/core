package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final 붙은건 필수값 = requiredArg. 그러므로 final 붙은 필드를 파라미터로 갖는 생성자를 자동으로 생성해줌
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }


//    @Autowired
        public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        System.out.println("1. OrderServiceImpl.OrderServiceImpl");
            this.memberRepository = memberRepository;
            this.discountPolicy = discountPolicy;
    }

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 이런식으로 Impl에 직접 접근해서 교체하는 것은 좋지 않다. OCP DIP 위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 얘도 이렇게 주석처리 해버리면 Null Point Exception(NPE)가 뜬다

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}