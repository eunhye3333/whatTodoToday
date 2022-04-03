package com.root.whattodotoday.todo.controller;

import com.root.whattodotoday.member.controller.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {

    @GetMapping("/todo/main")
    public String doTodo(){
        return "todo/main";
    }
}
