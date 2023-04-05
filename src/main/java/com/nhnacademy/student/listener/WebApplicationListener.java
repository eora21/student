package com.nhnacademy.student.listener;


import com.nhnacademy.student.gender.Gender;
import com.nhnacademy.student.repository.MapStudentRepository;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Random;

@WebListener
public class WebApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        StudentRepository studentRepository = new MapStudentRepository();
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
