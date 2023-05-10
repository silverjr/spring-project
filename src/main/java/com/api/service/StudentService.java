package com.api.service;

import com.api.entity.Student;
import com.api.error.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student createStudent(Student student);

   public Student fetchStudentById(Long studentId) throws StudentNotFoundException;

    void deleteStudentById(Long studentId);

    Student updateStudent(Long studentId, Student student);

    Student findByFirstName(String firstName);
}
