package com.example.libraryservice.errors;

public class FolderNotFoundException extends RuntimeException {
    public FolderNotFoundException() {
        super();
    }

    public FolderNotFoundException(String message) {
        super(message);
    }
}
