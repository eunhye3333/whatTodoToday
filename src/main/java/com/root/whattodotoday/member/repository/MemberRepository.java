package com.root.whattodotoday.member.repository;

import com.root.whattodotoday.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    public Member findByUsername(String insertId) {
        return null;
    }
}
