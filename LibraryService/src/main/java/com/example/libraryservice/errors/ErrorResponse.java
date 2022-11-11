package com.example.libraryservice.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
public class ErrorResponse {
    // customizing timestamp serialization format
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    public ErrorResponse() {
        timestamp = new Date();
    }

    public ErrorResponse(
            HttpStatus httpStatus,
            String message
    ) {
        this();

        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

}

