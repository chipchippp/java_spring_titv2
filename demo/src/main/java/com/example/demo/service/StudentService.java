package com.example.demo.service;

import com.example.demo.entity.Students;
import com.example.demo.repository.StudentRepository;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class StudentService implements IStudentService{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getAllStudents() {
       return studentRepository.findAll();
    }


    @Override
    public Students getStudentsById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveStudents(Students students) {
        studentRepository.save(students);
    }

    @Override
    @Transactional
    public void updateStudents(Long id, Students students) {
        Students student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(students.getName());
            student.setEmail(students.getEmail());
            studentRepository.save(student);
        }
    }

    @Override
    @Transactional
    public String deleteStudents(Long id) {
        studentRepository.deleteById(id);
        return "null";
    }

    @Override
    public String deleteAll() {
        studentRepository.deleteAll();
        return "null";
    }

//    @Override
//    public int updateAllTen(String name) {
//        String jqpl = "UPDATE SinhVien s SET s.ten = :t";
//        Query query =  this.studentRepository.createNamedQuery(jqpl);
//        return query.setParameter("t", name).executeUpdate();
//    }

//    @Override
//    public Students update(Students students) {
//        return this.studentRepository.merge(students);
//    }


//    @Override
//    public List<Students> getByName(String name) {
//        String jqpl = "SELECT s FROM SinhVien s WHERE s.ten = :t";
//        TypedQuery<Students> typedQuery =  this.studentRepository.createNamedQuery(jqpl, Students.class);
//        return typedQuery.setParameter("t", name).getResultList();
//    }
}
