package com.root.whattodotoday.todo.repository;

import com.root.whattodotoday.todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    public void save(Todo todo) {
        if(todo.getTodoNo() == null){
            em.persist(todo);
        } else {
            em.merge(todo);
        }
    }

    public List<Todo> findAll() {
        return em.createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }
}
