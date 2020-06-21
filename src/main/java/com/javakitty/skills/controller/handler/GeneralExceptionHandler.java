package com.javakitty.skills.controller.handler;

import com.javakitty.skills.model.exception.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(WebRequest webRequest) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(NOT_FOUND.getReasonPhrase());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaughtException(
            Exception ex) {
        log.error("Something went wrong: ", ex);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(INTERNAL_SERVER_ERROR.getReasonPhrase());

    }

}
