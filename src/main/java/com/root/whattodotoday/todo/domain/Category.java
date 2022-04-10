package com.root.whattodotoday.todo.domain;

import com.root.whattodotoday.member.domain.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SequenceGenerator(
        name = "CATE_SEQ_GEN",
        sequenceName = "SEQ_CATE",
        initialValue = 1,
        allocationSize = 1
)
public class Category {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CATE_SEQ_GEN"
    )
    @Column(name = "category_no")
    private Long categoryNo;

    private String categoryTitle;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Todo> todos = new ArrayList<>();

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    public void initCategory(String categoryTitle){
        this.categoryTitle = categoryTitle;
    }

}
