package com.inflearn.springbasic.member;

import com.inflearn.springbasic.config.AppConfig;

public class MemberApp {

    public static void main(String[] args) {
        //AppConfig에서 의존성 주입
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }

}
