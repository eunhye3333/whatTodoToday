package com.root.whattodotoday.todo.controller;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class TodoForm {
    private String todoContent;
    private LocalDateTime todoDate;
    private String categoryTitle;
}
