package com.students.service;

import com.students.dto.StudentRequest;
import com.students.dto.StudentResponse;
import com.students.exception.ResourceNotFoundException;
import com.students.model.Student;
import com.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentResponse mapToResponse(Student student) {
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                student.getAge()
        );
    }

    @Override
    public StudentResponse addStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setCourse(studentRequest.getCourse());
        student.setAge(studentRequest.getAge());
        Student saved = studentRepository.save(student);
        return mapToResponse(saved);
    }

    @Override
    public StudentResponse getStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return mapToResponse(student);
    }

    @Override
    public Page<StudentResponse> getAllStudents(Pageable pageable) {
        Page<Student> studentsPage = studentRepository.findAll(pageable);
        return studentsPage.map(this::mapToResponse);
    }

    @Override
    public List<StudentResponse> searchStudents(String search) {
        List<Student> students;
        if (search == null || search.isBlank()) {
            students = studentRepository.findAll();
        } else {
            students = studentRepository.findByNameContainingIgnoreCaseOrCourseContainingIgnoreCase(search, search);
        }
        return students.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse updateStudent(Integer id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setCourse(studentRequest.getCourse());
        student.setAge(studentRequest.getAge());

        Student updated = studentRepository.save(student);
        return mapToResponse(updated);
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(student);
    }
}
