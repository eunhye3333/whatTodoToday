package com.root.whattodotoday.todo.repository;

import com.root.whattodotoday.todo.domain.Category;
import com.root.whattodotoday.todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    public Long save(Category category) {
        if(category.getCategoryNo() == null){
            em.persist(category);
        } else {
            em.merge(category);
        }

        return category.getCategoryNo();
    }

    public Long save(Todo todo) {
        if(todo.getTodoNo() == null){
            em.persist(todo);
        } else {
            em.merge(todo);
        }

        return todo.getTodoNo();
    }

    public List<Category> findAllCategory() {
        return em.createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    public List<Todo> findAllTodo() {
        return em.createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }


    public List<Category> findCategoryList(Long memberNo) {
        String jpql = "select c from Category c where c.member = " + memberNo;
        return em.createQuery(jpql, Category.class)
                .getResultList();
    }
}
