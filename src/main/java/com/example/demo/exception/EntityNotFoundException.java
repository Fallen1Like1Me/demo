package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id) {
        super("не найден человек по айди " + id);
    }
}
//todo сделать текст ошибки универсальным(принимает стринг и ид)