package com.root.whattodotoday.todo.domain;

import com.root.whattodotoday.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임 -> id 값이 null이면 알아서 AUTO_INCREMENT 해줌
    @Column(name = "todo_no")
    private Long todoNo;

    private String todoContent;
    private LocalDateTime todoDate;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_no")
    private Category category;

    public void initTodo(String todoContent){
        this.todoContent = todoContent;
        this.todoDate = LocalDateTime.now();
        this.status = TodoStatus.YET;
    }
}
