package com.example.demo.entity;

public class ErrorResponseee {
    private int status;
    private String message;
    private long timeStamp;

    public ErrorResponseee(int status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }
}
