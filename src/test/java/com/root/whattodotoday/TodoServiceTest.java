package com.root.whattodotoday;

import com.root.whattodotoday.member.domain.Member;
import com.root.whattodotoday.todo.domain.Category;
import com.root.whattodotoday.todo.domain.Todo;
import com.root.whattodotoday.todo.repository.TodoRepository;
import com.root.whattodotoday.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class TodoServiceTest {
    @Autowired TodoService todoService;
    @Autowired TodoRepository todoRepository;


}
