package com.root.whattodotoday.category.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_no")
    private Long categoryNo;

    private String categoryTitle;
}
