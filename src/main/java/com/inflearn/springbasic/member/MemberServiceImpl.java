package com.inflearn.springbasic.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //생성자를 통해 어떤 구현 객체가 들어올지 모른다.
    //어떤 구현 객체를 주입할지는 오직 외부에서 결정한다.
    //의존관계에 대한 고민은 외부에 마틱고 실행에만 집중한다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
