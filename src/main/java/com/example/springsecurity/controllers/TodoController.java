package com.example.springsecurity.controllers;

import com.example.springsecurity.models.TodoList;
import com.example.springsecurity.services.TodoListService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    public final TodoListService todoListService;

    public TodoController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping()
    public List<TodoList> GetTodos()
    {
        return todoListService.getAll();
    }
    @Secured("ROLE_ADMIN")
    @PostMapping()
    public TodoList addTodo(@RequestBody TodoList todoList)
    {
        return todoListService.addTodoList(todoList);
    }
    @Secured("ROLE_USER")
    @GetMapping("/{id}")
    public List<TodoList> GetTodoByUserID(@PathVariable Long id)
    {
        return todoListService.getTodoListsByUserId(id);
    }
}
