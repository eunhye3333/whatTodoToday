package com.root.whattodotoday.member.repository;

import com.root.whattodotoday.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Member findByUsername(String insertId) {
        return em.find(Member.class, insertId);
    }

    public void save(Member member) {
        em.persist(member);
    }
}