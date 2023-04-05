package com.nhnacademy.student.servlet;

import com.nhnacademy.student.gender.Gender;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/student/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String genderStr = req.getParameter("gender");
        String ageStr = req.getParameter("age");

        log.info("회원 등록: {} {} {} {}", id, name, genderStr, ageStr);

        try {
            int age = Integer.parseInt(ageStr);

            if (age < 20 || 30 < age) {
                throw new NumberFormatException();
            }

            studentRepository.save(
                    new Student(id, name, Gender.valueOf(genderStr), age));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("값을 변환할 수 없습니다.");
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("옳지 않은 값이 전달되었습니다.");
        }

        resp.sendRedirect("/student/view?id=" + id);
    }
}
