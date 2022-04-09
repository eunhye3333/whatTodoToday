package com.root.whattodotoday.member.repository;

import com.root.whattodotoday.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

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

    public List<Member> findById(String id) {
        return em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", id) // 파라미터 바인딩
                .getResultList();
    }
}