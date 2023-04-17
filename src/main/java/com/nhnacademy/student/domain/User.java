package com.nhnacademy.student.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class User {
    private String userId;
    @Setter
    private String userName;
    @Setter
    private String userPassword;
}
