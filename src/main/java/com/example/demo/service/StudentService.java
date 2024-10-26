package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long studentId);
    List<Student> getAllStudents();
    Student updateStudent(Student student);
    void deleteStudent(Long studentId);
    void deleteAllStudents();
    long countStudents();
    boolean existsById(Long studentId);
}