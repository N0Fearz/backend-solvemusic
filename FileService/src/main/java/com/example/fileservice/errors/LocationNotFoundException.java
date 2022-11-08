package com.example.fileservice.errors;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException() {
        super();
    }

    public LocationNotFoundException(String message) {
        super(message);
    }
}
