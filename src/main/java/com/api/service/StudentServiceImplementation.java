package com.api.service;

import com.api.entity.Student;
import com.api.error.StudentNotFoundException;
import com.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService{

    @Autowired
    public StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student fetchStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Student> student = studentRepository.findById(studentId);

        if (!student.isPresent()) {
            throw new StudentNotFoundException("Student not Available");
        }
        return student.get();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student studentObj = studentRepository.findById(studentId).get();
        if (Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())) {
            studentObj.setFirstName(student.getFirstName());
        }

        if (Objects.nonNull(student.getMiddleName()) && !"".equalsIgnoreCase(student.getMiddleName())) {
            studentObj.setMiddleName(student.getMiddleName());
        }

        if (Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())) {
            studentObj.setLastName(student.getLastName());
        }

        if (Objects.nonNull(student.getAge())) {
            studentObj.setAge(student.getAge());
        }

        return studentRepository.save(studentObj);
    }

    @Override
    public Student findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

}
