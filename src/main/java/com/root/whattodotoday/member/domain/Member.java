package com.root.whattodotoday.member.domain;

import com.root.whattodotoday.todo.domain.Category;
import com.root.whattodotoday.todo.domain.Todo;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//@SequenceGenerator(
//        name="MEM_SEQ_GEN", //시퀀스 제너레이터 이름
//        sequenceName="SEQ_MEM", //시퀀스 이름
//        initialValue=1, //시작값
//        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
//)
public class Member {

    @Id
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE, // 사용할 전략을 시퀀스로 선택
//            generator = "MEM_SEQ_GEN" // 시퀀스의 식별자 지정
//    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    private String id;
    private String pw;
    private String nickname;
    private String email;

    @Column(length = 1, columnDefinition = "varchar(1) default 'Y'")
    @Enumerated(EnumType.STRING)
    private MemberStatus status = MemberStatus.Y;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

    public void initMember(String id, String pw, String nickname, String email){
        this.id = id;
        this.pw = pw;
        this.nickname = nickname;
        this.email = email;
    }

}
