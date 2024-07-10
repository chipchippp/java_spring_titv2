package com.example.demo.controllers;

import com.example.demo.entity.ErrorResponseee;
import com.example.demo.entity.Students;
import com.example.demo.exception.StudentException;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Students> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable Long id) {
        Students result = null;
        studentService.getStudentsById(id);
        if (result == null) {
            throw new StudentException("Student id not found - " + id);
        }
        return result;
    }
//    @GetMapping("/index/{index}")
//    public Students getStudentByIndex(@PathVariable String index) {
//        Students student = null;
//        try {
//            student = studentService.getStudentsById(index);
//        } catch (Exception e) {
//            throw new Students("Student index not found - " + index);
//        }
//        return student;
//    }
    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Students students) {
        studentService.saveStudents(students);
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Students students) {
        studentService.updateStudents(id, students);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudents(id);
    }

}           
