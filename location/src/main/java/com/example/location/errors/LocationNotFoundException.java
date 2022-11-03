package com.example.location.errors;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException() {
        super();
    }

    public LocationNotFoundException(String message) {
        super(message);
    }
}
