package com.example.demo.repository;

import com.example.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {
//        Students merge(Students students);
//    TypedQuery<Students> createNamedQuery(String jqpl, Class<Students> studentsClass);

}
