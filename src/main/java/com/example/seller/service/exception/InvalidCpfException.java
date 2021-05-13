package com.example.seller.service.exception;

public class InvalidCpfException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCpfException() {
        super();
    }

    public InvalidCpfException(String message) {
        super(message);
    }
}
