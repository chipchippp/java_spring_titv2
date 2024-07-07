package com.example.demo.exception;

import com.example.demo.entity.ErrorResponseee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(StudentException exc) {
        ErrorResponseee error = new ErrorResponseee(HttpStatus.NOT_FOUND.value(), exc.getMessage());
//        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((ErrorResponse) error);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc) {
        ErrorResponseee error = new ErrorResponseee(HttpStatus.NOT_FOUND.value(), exc.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body((ErrorResponse) error);
    }
}
