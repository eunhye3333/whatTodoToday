package com.root.whattodotoday.member.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@SequenceGenerator(
        name="MEM_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="SEQ_MEM", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class Member {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
            generator = "MEM_SEQ_GEN" // 시퀀스의 식별자 지정
    )
    @Column(name = "member_no")
    private Long memberNo;

    private String id;
    private String pw;
    private String nickname;
    private String email;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;


}
