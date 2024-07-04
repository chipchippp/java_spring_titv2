package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sinhvien")

public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ten", nullable = false, length = 50)
    private String name;
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    public Students() {
    }

    public Students(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Students(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
