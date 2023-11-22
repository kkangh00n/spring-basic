package com.inflearn.springbasic.config;

import com.inflearn.springbasic.discount.FixDiscountPolicy;
import com.inflearn.springbasic.member.MemberService;
import com.inflearn.springbasic.member.MemberServiceImpl;
import com.inflearn.springbasic.member.MemoryMemberRepository;
import com.inflearn.springbasic.order.OrderService;
import com.inflearn.springbasic.order.OrderServiceImpl;

//애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
//생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)
//Dependency Injection
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
            new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
