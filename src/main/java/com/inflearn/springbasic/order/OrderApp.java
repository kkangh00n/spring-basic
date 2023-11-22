package com.inflearn.springbasic.order;

import com.inflearn.springbasic.member.Grade;
import com.inflearn.springbasic.member.Member;
import com.inflearn.springbasic.member.MemberService;
import com.inflearn.springbasic.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
