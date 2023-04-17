package com.nhnacademy.student.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nhnacademy.student.gender.Gender;
import com.nhnacademy.student.valid.EnumPattern;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class Student implements Serializable {
    private final String id;
    private String name;
    @EnumPattern(regexp = "M|F")
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

    public Student(StudentDto studentDto) {
        this.id = studentDto.getId();
        this.name = studentDto.getName();
        this.gender = studentDto.getGender();
        this.age = studentDto.getAge();
        this.createdAt = LocalDateTime.now();
    }

    public void update(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}

