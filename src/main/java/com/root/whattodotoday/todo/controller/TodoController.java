package com.root.whattodotoday.todo.controller;

import com.root.whattodotoday.member.controller.MemberForm;
import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.todo.domain.Category;
import com.root.whattodotoday.todo.domain.Todo;
import com.root.whattodotoday.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo/new")
    public String doTodo(){
        return "todo/createTodoForm";
    }

    @PostMapping("/todo/new")
    public String create(TodoForm form){
        Todo todo = new Todo();
        Category category = new Category(form.getCategoryTitle());
        Member member = new Member(); // 현재 접속한 멤버 가지고 오기

        todo.initTodo(form.getTodoContent(), form.getTodoDate(), member, category);

        todoService.saveTodo(todo);
        return "redirect:/todo/createTodoForm";
    }
}
