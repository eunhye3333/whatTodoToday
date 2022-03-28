package com.root.whattodotoday.member.domain;

import com.root.whattodotoday.todo.domain.TodoStatus;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_no")
    private int memberNo;

    private String id;
    private String pw;
    private String nickname;
    private String email;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;


}
