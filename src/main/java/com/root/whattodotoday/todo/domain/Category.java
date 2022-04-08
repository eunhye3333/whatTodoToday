package com.root.whattodotoday.todo.domain;

import lombok.Getter;

import javax.persistence.*;

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

    public Category(String categoryTitle){
        this.categoryTitle = categoryTitle;
    }
}
