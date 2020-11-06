package com.thoughtworks.capacity.gtb.mvc.handler;

import com.thoughtworks.capacity.gtb.mvc.exceptions.loginException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(loginException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Error> handle(loginException ex) {
        Error error = new Error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
