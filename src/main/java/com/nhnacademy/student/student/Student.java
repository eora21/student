package com.nhnacademy.student.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nhnacademy.student.gender.Gender;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class Student implements Serializable {
    private final String id;
    private String name;
    private Gender gender;
    private int age;
    private final LocalDateTime createdAt;

    @Builder
    @JsonCreator
    public Student(@JsonProperty("id") String id, @JsonProperty("name") String name,
                   @JsonProperty("Gender") Gender gender, @JsonProperty("age") int age,
                   @JsonProperty("createdAt") LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.createdAt = createdAt;
    }

    public Student(String id, String name, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}

