package com.nhnacademy.student.repository;

import com.nhnacademy.student.domain.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MapStudentRepository implements StudentRepository {
    private final Map<String, Student> studentMap = new ConcurrentHashMap<>();

    @Override
    public void save(Student student) {
        if (existById(student.getId())) {
            throw new IllegalArgumentException("해당 id를 지닌 학생이 이미 있습니다.");
        }
        studentMap.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        if (!existById(student.getId())) {
            throw new IllegalArgumentException("해당 id를 지닌 학생이 없습니다.");
        }
        studentMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(String id) {
        studentMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public boolean existById(String id) {
        return studentMap.containsKey(id);
    }
}
