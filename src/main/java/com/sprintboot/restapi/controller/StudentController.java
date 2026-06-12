package com.sprintboot.restapi.controller;

import com.sprintboot.restapi.entity.Student;
import com.sprintboot.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    //Get All the Students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PostMapping("/student/update")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student) {
        Student existingStudent = studentRepository.findById(student.getRollNo()).orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setFullName(student.getFullName());
        existingStudent.setPercentage(student.getPercentage());
        existingStudent.setBranch(student.getBranch());
        return studentRepository.save(existingStudent);
    }

    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }
}
