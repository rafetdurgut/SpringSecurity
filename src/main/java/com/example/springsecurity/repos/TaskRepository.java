package com.example.springsecurity.repos;

import com.example.springsecurity.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTodoListId(Long todoListID);

}
