package com.nhnacademy.student.controller.student;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.domain.StudentDto;
import com.nhnacademy.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/student/register")
@RequiredArgsConstructor
public class StudentRegisterController {
    private final StudentRepository studentRepository;

    @PostMapping
    public String postStudentRegister(StudentDto studentDto) {

        log.info("회원 등록: {} {} {} {}", studentDto.getId(), studentDto.getName(),
                studentDto.getGender(), studentDto.getAge());
        studentRepository.save(new Student(studentDto));
        return "redirect:/student/view?id=" + studentDto.getId();
    }

    @GetMapping
    public String getStudentForm() {
        return "student/register";
    }
}
