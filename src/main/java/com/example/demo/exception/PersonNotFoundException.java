package com.example.demo.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("не найден человек по айди " + id);
    }
}
