package com.nhnacademy.student.domain;

import com.nhnacademy.student.gender.Gender;
import com.nhnacademy.student.valid.EnumPattern;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class StudentDto {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    @EnumPattern(regexp = "M|F")
    private Gender gender;
    @Min(20)
    @Max(30)
    private int age;
}
