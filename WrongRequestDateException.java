package com.example.demo.exception;

public class WrongRequestDateException extends RuntimeException {
    public WrongRequestDateException(String message) {
        super(message);
    }
}
