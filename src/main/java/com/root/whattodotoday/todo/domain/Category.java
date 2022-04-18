package com.root.whattodotoday.todo.domain;

import com.root.whattodotoday.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
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

    public void initCategory(String categoryTitle){
        this.categoryTitle = categoryTitle;
    }

}
