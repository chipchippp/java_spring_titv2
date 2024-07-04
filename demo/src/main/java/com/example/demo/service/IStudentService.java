package com.example.demo.service;

import com.example.demo.entity.Students;

import java.util.List;

public interface IStudentService {
    public List<Students> getAllStudents();
    public Students getStudentsById(Long id);
    public void saveStudents(Students students);
    public void updateStudents(Long id, Students students);
    public String deleteStudents(Long id);

//    public int updateAllTen(String name);
//    public Students update(Students students);
    public String deleteAll();
}
