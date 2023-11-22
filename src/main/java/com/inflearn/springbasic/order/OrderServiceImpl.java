package com.inflearn.springbasic.order;

import com.inflearn.springbasic.discount.DiscountPolicy;
import com.inflearn.springbasic.discount.FixDiscountPolicy;
import com.inflearn.springbasic.discount.RateDiscountPolicy;
import com.inflearn.springbasic.member.Member;
import com.inflearn.springbasic.member.MemberRepository;
import com.inflearn.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 추상체와 구현체에 함께 의존 -> DIP 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 확장 시 변경도 함께 일어남 -> OCP 위반
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
