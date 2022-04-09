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
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }


    public List<Todo> findTodo() {
        return todoRepository.findAll();
    }
}
