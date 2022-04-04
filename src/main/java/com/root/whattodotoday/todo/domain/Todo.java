package com.root.whattodotoday.todo.domain;

import com.root.whattodotoday.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@SequenceGenerator(
        name = "TODO_SEQ_GEN",
        sequenceName = "SEQ_TODO",
        initialValue = 1,
        allocationSize = 1
)
public class Todo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TODO"
    )
    @Column(name = "todo_no")
    private Long todoNo;

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

    public void initTodo(String todoContent, LocalDateTime todoDate, Member member, Category category){
        this.todoContent = todoContent;
        this.todoDate = todoDate;
        this.member = member;
        this.category = category;
    }
}
