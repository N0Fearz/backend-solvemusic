package com.example.libraryservice.errors;

public class ParameterException extends RuntimeException{
    public ParameterException() {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }
}
