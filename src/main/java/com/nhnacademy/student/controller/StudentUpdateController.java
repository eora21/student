package com.nhnacademy.student.controller;

import com.nhnacademy.student.gender.Gender;
import com.nhnacademy.student.init.RequestMapping;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.servlet.FrontServlet;
import com.nhnacademy.student.student.Student;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequestMapping(url = "/student/update.do", method = RequestMapping.Method.POST)
public class StudentUpdateController implements Command {

    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository =
                (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String genderStr = request.getParameter("gender");
        String ageStr = request.getParameter("age");

        if (!studentRepository.existById(id)) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        try {
            int age = Integer.parseInt(ageStr);

            if (age < 20 || 30 < age) {
                throw new NumberFormatException();
            }

            studentRepository.update(
                    new Student(id, name, Gender.valueOf(genderStr), age));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("값을 변환할 수 없습니다.");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("옳지 않은 값이 전달되었습니다.");
        }

        return FrontServlet.REDIRECT_PREFIX + "/student/view.do?id=" + id;
    }
}
