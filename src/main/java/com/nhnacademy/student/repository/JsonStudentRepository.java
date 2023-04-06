package com.nhnacademy.student.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.student.student.Student;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonStudentRepository implements StudentRepository {
    private final ObjectMapper objectMapper;
    private final String jsonFilePath;

    public JsonStudentRepository(String realFilePath) {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        this.jsonFilePath = realFilePath;
        File file = new File(jsonFilePath);

        if (file.exists()) {
            try {
                Files.delete(file.toPath());
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    private synchronized List<Student> readJsonFile() {
        File file = new File(jsonFilePath);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            return objectMapper.readValue(bufferedReader, new TypeReference<List<Student>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void writeJsonFile(List<Student> studentList) {
        File file = new File(jsonFilePath);

        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            objectMapper.writeValue(bufferedWriter, studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Student student) {
        List<Student> students = readJsonFile();
        students.add(student);
        writeJsonFile(students);
    }

    @Override
    public void update(Student student) {
        List<Student> students = readJsonFile();
        Student target = students.stream()
                .filter(stud -> student.getId().equals(stud.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
        target.update(student.getName(), student.getGender(), student.getAge());
        writeJsonFile(students);
    }

    @Override
    public void deleteById(String id) {
        List<Student> students = readJsonFile();
        students.removeIf(student -> id.equals(student.getId()));
        writeJsonFile(students);
    }

    @Override
    public Student getStudentById(String id) {
        return readJsonFile().stream()
                .filter(student -> id.equals(student.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
    }

    @Override
    public List<Student> getStudents() {
        return readJsonFile();
    }

    @Override
    public boolean existById(String id) {
        return readJsonFile().stream()
                .anyMatch(student -> id.equals(student.getId()));
    }
}
