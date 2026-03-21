package com.library.project.library.controller;

import com.library.project.library.exception.NotLoginException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// REST API에서 발생하는 예외를 잡아서 적절한 HTTP 응답으로 변환
@RestControllerAdvice
public class GlobalExceptionHandler {

    // NotLoginException 발생 시 401 응답 반환
    @ExceptionHandler(NotLoginException.class)
    public ResponseEntity<String> handleNotLogin(NotLoginException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}