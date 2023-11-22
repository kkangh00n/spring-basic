package com.inflearn.springbasic.order;

import com.inflearn.springbasic.discount.DiscountPolicy;
import com.inflearn.springbasic.discount.FixDiscountPolicy;
import com.inflearn.springbasic.member.Member;
import com.inflearn.springbasic.member.MemberRepository;
import com.inflearn.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
