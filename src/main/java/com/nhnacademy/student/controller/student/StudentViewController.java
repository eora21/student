package com.nhnacademy.student.controller.student;

import com.nhnacademy.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentViewController {
    private final StudentRepository studentRepository;

    @GetMapping("/student/view")
    public String viewStudent(@RequestParam String id, Model model) {
        if (id == null || !studentRepository.existById(id)) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        model.addAttribute("student", studentRepository.getStudentById(id));
        return "/student/view";
    }
}