package com.devrenno.BackendSpringBoot.controllers.handlers;

import com.devrenno.BackendSpringBoot.dto.CustomError;
import com.devrenno.BackendSpringBoot.services.exceptions.ElementNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<CustomError> ElementNotFound(ElementNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
