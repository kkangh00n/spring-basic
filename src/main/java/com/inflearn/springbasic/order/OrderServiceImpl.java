package com.inflearn.springbasic.order;

import com.inflearn.springbasic.discount.DiscountPolicy;
import com.inflearn.springbasic.discount.RateDiscountPolicy;
import com.inflearn.springbasic.member.Member;
import com.inflearn.springbasic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자를 통해 어떤 구현 객체가 들어올지 모른다.
    //어떤 구현 객체를 주입할지는 오직 외부에서 결정한다.
    //의존관계에 대한 고민은 외부에 마틱고 실행에만 집중한다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
