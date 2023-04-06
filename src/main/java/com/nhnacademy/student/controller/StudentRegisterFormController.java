package com.nhnacademy.student.controller;

import com.nhnacademy.student.init.RequestMapping;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequestMapping(url = "/student/register.do")
public class StudentRegisterFormController implements Command {

    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) {
        return "/student/register.jsp";
    }
}
