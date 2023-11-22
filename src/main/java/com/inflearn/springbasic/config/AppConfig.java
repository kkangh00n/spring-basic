package com.inflearn.springbasic.config;

import com.inflearn.springbasic.discount.DiscountPolicy;
import com.inflearn.springbasic.discount.FixDiscountPolicy;
import com.inflearn.springbasic.member.MemberRepository;
import com.inflearn.springbasic.member.MemberService;
import com.inflearn.springbasic.member.MemberServiceImpl;
import com.inflearn.springbasic.member.MemoryMemberRepository;
import com.inflearn.springbasic.order.OrderService;
import com.inflearn.springbasic.order.OrderServiceImpl;

//애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
//생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)
//Dependency Injection
public class AppConfig {

    //리팩토링 후
    //중복 코드 제거 (new MemoryMemberRepository() 제거)
    //애플리케이션 전체 구성이 어떻게 되어있는지 파악 가능
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
            memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
