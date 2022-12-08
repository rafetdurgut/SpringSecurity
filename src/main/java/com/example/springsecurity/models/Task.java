package com.example.springsecurity.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String Description;
    @JsonIgnore
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "task")
    private Collection<Comment> comments = new ArrayList<>();
    private TaskStatus status;

    @JsonIgnore

    @ManyToOne
    @JoinColumn(name="todoListId")
    private TodoList todoList;

    public Long createdAt;
    public Long updatedAt;

    public Task(String title, String description, TaskStatus status) {
        this.title = title;
        Description = description;
        if (status==null)
            status = TaskStatus.OPEN;
        this.status = status;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }
}

