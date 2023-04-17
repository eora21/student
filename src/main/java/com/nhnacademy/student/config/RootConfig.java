package com.nhnacademy.student.config;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.domain.User;
import com.nhnacademy.student.gender.Gender;
import com.nhnacademy.student.repository.MapStudentRepository;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.repository.UserRepository;
import com.nhnacademy.student.repository.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.student",
    excludeFilters = { @ComponentScan.Filter(Controller.class)})
public class RootConfig {
    @Bean
    public UserRepository userRepository() {
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.addUser(new User("admin", "admin", "1234"));

        return userRepository;
    }

    @Bean
    public StudentRepository studentRepository() {
        StudentRepository studentRepository = new MapStudentRepository();

        Random random = new Random();

        for (int cnt = 0; cnt < 10; cnt++) {
            Student student = new Student("student" + cnt, "아카데미" + cnt,
                    Gender.values()[random.nextInt(Gender.values().length)],
                    random.nextInt(11) + 20);

            studentRepository.save(student);
        }

        return studentRepository;
    }
}
