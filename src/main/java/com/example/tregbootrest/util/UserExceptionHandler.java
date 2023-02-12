package com.example.tregbootrest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<UserErrorResponse> handleException (UserNotFoundException e) {
        UserErrorResponse response = new UserErrorResponse("user was not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
