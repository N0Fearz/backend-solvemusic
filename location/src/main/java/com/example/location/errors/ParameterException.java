package com.example.location.errors;

public class ParameterException extends RuntimeException{
    public ParameterException() {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }
}
