package com.root.whattodotoday.todo.controller;

import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.todo.domain.Category;
import com.root.whattodotoday.todo.domain.Todo;
import com.root.whattodotoday.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo/list")
    public String todoListView(Model model){
        List<Todo> todos = todoService.findTodo();
        model.addAttribute("todos", todos);

        return "/todo/todoList";
    }

    @PostMapping("/todo/new")
    public String create(TodoForm form, HttpSession session){
        Todo todo = new Todo();
        Category category = new Category(form.getCategoryTitle());
        Member member = (Member)session.getAttribute("member");

        todo.initTodo(form.getTodoContent(), member, category);

        todoService.saveTodo(todo);
        return "redirect:/todo/todoList";
    }

}
