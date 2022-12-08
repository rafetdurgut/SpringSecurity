package com.example.springsecurity.services;

import com.example.springsecurity.models.Comment;
import com.example.springsecurity.models.Task;
import com.example.springsecurity.repos.CommentRepository;
import com.example.springsecurity.repos.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;

    public void addTask(Task task)
    {
        taskRepository.save(task);
    }

    public List<Task> getTaskByTodo(Long todoId)
    {
        return taskRepository.findAllByTodoListId(todoId);
    }

    public void addComment(Comment comment, Long taskId)
    {
        comment.setTask(taskRepository.findById(taskId).get());
        commentRepository.save(comment);
    }

    public Collection<Comment> getCommentsByTaskId(Long taskId)
    {
        return taskRepository.findById(taskId).get().getComments();
    }

}
