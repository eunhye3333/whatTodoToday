package com.root.whattodotoday.todo.controller;

import com.root.whattodotoday.member.controller.MemberForm;
import com.root.whattodotoday.todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {

    @GetMapping("/todo/new")
    public String doTodo(){
        return "todo/createTodoForm";
    }

    @PostMapping("/todo/new")
    public String create(TodoForm form){
        Todo todo = new Todo();

//        todo.initTodo(form.getTodoContent(), form.getTodoDate());

        return "redirect:/todo/createTodoForm";
    }
}
