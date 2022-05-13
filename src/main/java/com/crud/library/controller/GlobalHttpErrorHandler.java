package com.crud.library.controller;

import com.crud.library.exceptions.CopyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CopyNotFoundException.class)
    public ResponseEntity<Object> handleTaskNotFoundException(CopyNotFoundException exception) {
        return new ResponseEntity<>("Copy doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
