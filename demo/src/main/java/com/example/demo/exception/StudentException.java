package com.example.demo.exception;

import org.springframework.http.HttpStatusCode;

public class StudentException extends RuntimeException{
    public StudentException(String message) {
        super(message);
    }
}
