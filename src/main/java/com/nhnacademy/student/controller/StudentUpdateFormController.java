package com.nhnacademy.student.controller;

import com.nhnacademy.student.init.RequestMapping;
import com.nhnacademy.student.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping(url = "/student/update.do")
public class StudentUpdateFormController implements Command {
    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository =
                (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");

        if (id == null || !studentRepository.existById(id)) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        request.setAttribute("student", studentRepository.getStudentById(id));
        return "/student/register.jsp";
    }
}
