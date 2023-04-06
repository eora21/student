package com.nhnacademy.student.controller;

import com.nhnacademy.student.init.RequestMapping;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.servlet.FrontServlet;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequestMapping(url = "/student/delete.do", method = RequestMapping.Method.POST)
public class StudentDeleteController implements Command {

    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository =
                (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        studentRepository.deleteById(id);
        return FrontServlet.REDIRECT_PREFIX + "/student/list.do";
    }
}
