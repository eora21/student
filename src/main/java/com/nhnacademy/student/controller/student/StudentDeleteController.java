package com.nhnacademy.student.controller.student;

import com.nhnacademy.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StudentDeleteController {
    private final StudentRepository studentRepository;

    @PostMapping("/student/delete")
    public String deleteStudent(@RequestParam String id) {
        studentRepository.deleteById(id);
        return "redirect:/student/list";
    }
}
