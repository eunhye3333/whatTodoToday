package com.root.whattodotoday.todo.controller;

import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.member.domain.MemberDetail;
import com.root.whattodotoday.todo.domain.Category;
import com.root.whattodotoday.todo.domain.Todo;
import com.root.whattodotoday.todo.domain.TodoStatus;
import com.root.whattodotoday.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo/list")
    public String todoListView(Model model, Authentication authentication){
        MemberDetail md = (MemberDetail) authentication.getPrincipal();

        List<Category> categories = todoService.findCategoryList(md.getMemberNo());
        model.addAttribute("categories", categories);

        return "/todo/todoList";
    }

    @PostMapping("/category/new")
    @ResponseBody
    public String createCategory(@RequestParam("categoryContent") String categoryContent, Authentication authentication){
        Category category = new Category();
        MemberDetail md = (MemberDetail) authentication.getPrincipal();
        Member member = new Member();
        member.setNo(md.getMemberNo());

        category.initCategory(categoryContent, member);

        Long categoryNo = todoService.saveCategory(category);
        return categoryNo.toString();
    }

    @PostMapping("/todo/new")
    @ResponseBody
    public String createTodo(@RequestParam("todoContent") String todoContent, @RequestParam("categoryNo") String no, Authentication authentication){
        Long categoryNo = Long.parseLong(no);

        MemberDetail md = (MemberDetail) authentication.getPrincipal();
        Member member = new Member();
        member.setNo(md.getMemberNo());

        Category category = new Category();
        category.newTodo(categoryNo, member);

        Todo todo = new Todo();
        todo.initTodo(todoContent, category);

        Long todoNo = todoService.saveTodo(todo);
        return todoNo.toString();
    }

    @PostMapping("/todo/done")
    @ResponseBody
    public String updateTodo(@RequestParam("todoNo") String no, @RequestParam("categoryNo") String cNo, @RequestParam("status") String status){
        Long todoNo = Long.parseLong(no);
        Long categoryNo = Long.parseLong(cNo);

        Category category = new Category();
        category.updateTodo(categoryNo);

        TodoStatus todoStatus;
        if(status.equals("YET")){
            todoStatus = TodoStatus.DONE;
        } else {
            todoStatus = TodoStatus.YET;
        }

        Todo todo = new Todo();
        todo.updateTodo(todoNo, category, todoStatus);

        Long todoN = todoService.saveTodo(todo);
        return todoN.toString();
    }

}
