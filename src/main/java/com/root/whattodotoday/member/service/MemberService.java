package com.root.whattodotoday.member.service;

import com.root.whattodotoday.member.controller.MemberForm;
import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.member.domain.MemberDetail;
import com.root.whattodotoday.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Transactional
    public String join(MemberForm form) {
        validateDuplicateMember(form);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        form.setPw(encoder.encode(form.getPw()));

        Member member = new Member();
        member.initMember(form.getId(), form.getPw(), form.getNickname(),"USER");

        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(MemberForm form) {
        Member findMember = memberRepository.findById(form.getId()).get(0);

        if(findMember != null){
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

    @Override
    public UserDetails loadUserByUsername(String insertId) throws UsernameNotFoundException {
        Member member = memberRepository.findById(insertId).get(0);

        if(member == null){
            throw new UsernameNotFoundException(insertId);
        }

        return new MemberDetail(member);
    }
}
