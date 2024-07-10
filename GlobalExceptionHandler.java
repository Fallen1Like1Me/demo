package com.example.demo.exceptionHandler;

import com.example.demo.exception.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlePersonNotFoundException(EntityNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
