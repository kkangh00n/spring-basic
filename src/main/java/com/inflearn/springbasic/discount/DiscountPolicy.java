package com.inflearn.springbasic.discount;

import com.inflearn.springbasic.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
