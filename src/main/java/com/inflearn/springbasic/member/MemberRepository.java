package com.inflearn.springbasic.member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);

}
