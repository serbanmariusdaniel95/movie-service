package com.typesoft.movie.service.controller;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<?> handleException(final FeignException exception) {
        return ResponseEntity.status(500).body(exception.getMessage());
    }
}
