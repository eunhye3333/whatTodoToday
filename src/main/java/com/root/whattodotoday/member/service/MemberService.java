package com.root.whattodotoday.member.service;

import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        // 중복 회원 검증

        memberRepository.save(member);
        return member.getMemberNo();
    }
}
