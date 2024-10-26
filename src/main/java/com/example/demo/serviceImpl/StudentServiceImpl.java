package com.example.demo.serviceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.orElse(null); // Return null if not found
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + student.getId()));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    
    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }
    
    @Override
    public long countStudents() {
        return studentRepository.count();
    }
    
    @Override
    public boolean existsById(Long studentId) {
        return studentRepository.existsById(studentId);
    }
}
