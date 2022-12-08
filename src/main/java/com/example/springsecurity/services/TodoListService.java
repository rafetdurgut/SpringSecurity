package com.example.springsecurity.services;

import com.example.springsecurity.models.TodoList;
import com.example.springsecurity.repos.CommentRepository;
import com.example.springsecurity.repos.TaskRepository;
import com.example.springsecurity.repos.TodoListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;

    public TodoList addTodoList(TodoList todo)
    {
        return  todoListRepository.save(todo);
    }

    public TodoList getTodoList(Long id)
    {
        return todoListRepository.findById(id).get();
    }

    public List<TodoList> getTodoListsByUserId(Long id)
    {
        return todoListRepository.findAllByUserId(id);
    }

    public List<TodoList> getAll() {
        return todoListRepository.findAll();
    }
}
