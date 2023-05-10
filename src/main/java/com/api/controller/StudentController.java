package com.api.controller;

import com.api.entity.Student;
import com.api.error.StudentNotFoundException;
import com.api.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //get all students
    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //create student
    @PostMapping("/student")
    public Student createStudent(@Valid @RequestBody Student student){
        return studentService.createStudent(student);
    }

    //select student
    @GetMapping("/student/{id}")
    public Student fetchStudentById(@PathVariable("id") Long studentId) throws StudentNotFoundException {
         return studentService.fetchStudentById(studentId);
    }

    //delete student
    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
        return "deleted student successfully..!!";
    }

    //update student info
    @PutMapping("/student/{id}")
    public Student updateStudentName(@PathVariable("id") Long studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }

    //fetch by first name
    @GetMapping("/student/name/{name}")
    public Student fetchStudentByName(@PathVariable("name") String firstName){
        return studentService.findByFirstName(firstName);
    }
}
