package com.nhnacademy.student.controller.student;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentListController {
    private final StudentRepository studentRepository;

    @GetMapping("/student/list")
    public String getStudentList(Model model) {
        List<Student> students = studentRepository.getStudents();
        model.addAttribute("students", students);
        return "student/list";
    }
}
