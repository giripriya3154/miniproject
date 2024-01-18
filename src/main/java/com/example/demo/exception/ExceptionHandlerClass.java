package com.example.demo.exception;

import com.example.demo.response.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleException(CustomException e) {
        StatusResponse response = new StatusResponse(e.getStatus(),e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
