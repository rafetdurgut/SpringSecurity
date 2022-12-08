package com.example.springsecurity.models;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GeneralDate {
    public Long createdAt;
    public Long updatedAt;
}
