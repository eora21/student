package com.nhnacademy.student.student;

import com.nhnacademy.student.gender.Gender;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Student {
    private String id;
    private String name;
    private Gender gender;
    private int age;
    private LocalDateTime createdAt;

    public Student(String id, String name, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }
}

