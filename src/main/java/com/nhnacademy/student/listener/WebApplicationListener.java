package com.nhnacademy.student.listener;


import com.nhnacademy.student.gender.Gender;
import com.nhnacademy.student.repository.JsonStudentRepository;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Random;

@WebListener
public class WebApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String jsonFilePath = "/WEB-INF/classes/json";
        String realFilePath = servletContext.getRealPath(jsonFilePath);

        StudentRepository studentRepository = new JsonStudentRepository(realFilePath);
        Random random = new Random();

        for (int cnt = 0; cnt < 10; cnt++) {
            Student student = new Student("student" + cnt, "아카데미" + cnt,
                    Gender.values()[random.nextInt(Gender.values().length)],
                    random.nextInt(11) + 20);

            studentRepository.save(student);
        }

        sce.getServletContext().setAttribute("studentRepository", studentRepository);
    }
}
