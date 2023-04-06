package com.nhnacademy.student.controller;

import com.nhnacademy.student.init.RequestMapping;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(url = "/student/list.do")
public class StudentListController implements Command {
    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository =
                (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        List<Student> students = studentRepository.getStudents();
        request.setAttribute("students", students);
        return "/student/list.jsp";
    }
}
