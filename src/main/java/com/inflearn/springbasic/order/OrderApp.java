package com.inflearn.springbasic.order;

import com.inflearn.springbasic.config.AppConfig;
import com.inflearn.springbasic.member.Grade;
import com.inflearn.springbasic.member.Member;
import com.inflearn.springbasic.member.MemberService;

public class OrderApp {

    public static void main(String[] args) {
        //AppConfig에서 의존성 주입
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
