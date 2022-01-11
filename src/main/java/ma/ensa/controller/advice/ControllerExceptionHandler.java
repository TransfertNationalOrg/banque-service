package ma.ensa.controller.advice;

import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<?> handleNotFoundException(NotFoundException exception){
        String responseMessage = "["+exception.getId()+"] is nowhere to be found.";
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseMessage);
    }

    @ExceptionHandler(DuplicatedException.class)
    private ResponseEntity<?> handleDuplicatedException(DuplicatedException exception){
        String responseMessage = "["+exception.getId()+"] is already existing.";
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(responseMessage);
    }
}
