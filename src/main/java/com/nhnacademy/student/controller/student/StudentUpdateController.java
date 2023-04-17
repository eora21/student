package com.nhnacademy.student.controller.student;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.domain.StudentDto;
import com.nhnacademy.student.exception.ValidationFailedException;
import com.nhnacademy.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/student/update")
public class StudentUpdateController {

    private final StudentRepository studentRepository;

    @GetMapping
    public String getStudentUpdateForm(@RequestParam String id, Model model) {
        if (id == null || !studentRepository.existById(id)) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        model.addAttribute("student", studentRepository.getStudentById(id));
        return "/student/register";
    }

    @PostMapping
    public String updateStudent(@Valid StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        throw new ValidationFailedException(bindingResult);
    }

        if (!studentRepository.existById(studentDto.getId())) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }

        studentRepository.update(new Student(studentDto));
        return "redirect:/student/view?id=" + studentDto.getId();
    }
}
