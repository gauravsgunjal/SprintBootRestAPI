package com.sprintboot.restapi.controller;

import com.sprintboot.restapi.entity.Student;
import com.sprintboot.restapi.repository.ApiResponse;
import com.sprintboot.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        ApiResponse<List<Student>> response =new ApiResponse<>(
            HttpStatus.OK.value(),
            "Students fetched successfully",
            students
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return ResponseEntity.ok(
            new ApiResponse<>(
                HttpStatus.OK.value(),
                "Student fetched successfully",
                student
            )
        );
    }

    @PostMapping("/student/add")
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(
        new ApiResponse<>(
            HttpStatus.CREATED.value(),
            "Student added successfully",
            savedStudent
            )
        );
    }

    @PostMapping("/student/update")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@RequestBody Student student) {
        Student existingStudent = studentRepository.findById(student.getRollNo()).orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setFullName(student.getFullName());
        existingStudent.setPercentage(student.getPercentage());
        existingStudent.setBranch(student.getBranch());
        Student updatedStudent = studentRepository.save(existingStudent);

        return ResponseEntity.ok(new ApiResponse<>(
            HttpStatus.OK.value(),
            "Student updated successfully",
            updatedStudent)
        );
    }

    @DeleteMapping("/student/delete/{id}")

    public ResponseEntity<ApiResponse<Object>> deleteStudent(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(student);

        return ResponseEntity.ok(
            new ApiResponse<>(
                HttpStatus.OK.value(),
                "Student deleted successfully",
                null
            )
        );
    }
}
