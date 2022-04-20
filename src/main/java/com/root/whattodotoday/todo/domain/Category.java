package com.root.whattodotoday.todo.domain;

import com.root.whattodotoday.member.domain.Member;
import lombok.Getter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_no")
    private Long categoryNo;

    private String categoryTitle;

    @OneToMany(mappedBy = "category")
    private List<Todo> todos = new ArrayList<>();

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void initCategory(String categoryTitle, Member member){
        this.categoryTitle = categoryTitle;
        this.member = member;
    }

    public void newTodo(Long categoryNo, Member member){
        this.categoryNo = categoryNo;
        this.member = member;
    }

}
