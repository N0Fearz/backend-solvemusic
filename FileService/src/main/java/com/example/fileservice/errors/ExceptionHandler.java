package src.main.java.com.example.fileservice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNullException(Exception e){
        HttpStatus status = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage()
                ),
                status
        );
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(src.main.java.com.example.fileservice.errors.ParameterException.class)
    public ResponseEntity<ErrorResponse> handleParameterExceptions(
            Exception e
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // 400

        return new ResponseEntity<>(
                new ErrorResponse(
                        status,
                        e.getMessage()
                ),
                status
        );
    }

}
