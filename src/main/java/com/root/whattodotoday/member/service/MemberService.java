package com.root.whattodotoday.member.service;

import com.root.whattodotoday.member.controller.MemberForm;
import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getMemberNo();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findById(member.getId());

        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public Member findOne(MemberForm memberForm) {
        Member member = memberRepository.findById(memberForm.getId()).get(0);

        if(!member.getPw().equals(memberForm.getPw())){
            return null;
        }

        return member;
    }
}
