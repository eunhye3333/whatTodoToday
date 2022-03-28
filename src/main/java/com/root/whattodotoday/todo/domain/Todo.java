package com.root.whattodotoday.todo.domain;

import com.root.whattodotoday.category.domain.Category;
import com.root.whattodotoday.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Todo {

    @Id
    @GeneratedValue
    @Column(name = "todo_no")
    private int todoNo;

    private String todoContent;
    private LocalDateTime todoDate;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_no")
    private Category category;
}
