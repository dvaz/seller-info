package com.example.seller.controller.handler;

import com.example.seller.service.exception.InvalidCpfException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({InvalidCpfException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity invalid(InvalidCpfException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
    }
}
