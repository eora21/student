package com.nhnacademy.student.domain;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginRequest {
    @NotBlank
    private String userId;
    @NotBlank
    private String userPassword;
}
