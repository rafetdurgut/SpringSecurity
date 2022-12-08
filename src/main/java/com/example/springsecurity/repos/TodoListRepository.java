package com.example.springsecurity.repos;

import com.example.springsecurity.models.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    List<TodoList> findAllByUserId(Long userId);
}
