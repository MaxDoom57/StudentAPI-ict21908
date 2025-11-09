package com.students.service;

import com.students.dto.StudentRequest;
import com.students.dto.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    StudentResponse addStudent(StudentRequest studentRequest);
    StudentResponse getStudentById(Integer id);
    Page<StudentResponse> getAllStudents(Pageable pageable);
    List<StudentResponse> searchStudents(String search);
    StudentResponse updateStudent(Integer id, StudentRequest studentRequest);
    void deleteStudent(Integer id);
}
