package com.root.whattodotoday.todo.service;

import com.root.whattodotoday.todo.domain.Category;
import com.root.whattodotoday.todo.domain.Todo;
import com.root.whattodotoday.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Long saveCategory(Category category) {
        return todoRepository.save(category);
    }

    @Transactional
    public Long saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Category> findCategory() {
        return todoRepository.findAllCategory();
    }

    public List<Todo> findTodo() {
        return todoRepository.findAllTodo();
    }


    public List<Category> findCategoryList(Long memberNo) {
        return todoRepository.findCategoryList(memberNo);
    }
}
