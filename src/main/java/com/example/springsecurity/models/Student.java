package com.example.springsecurity.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Data
public class Student extends User{
    public String studentNumber;
}
