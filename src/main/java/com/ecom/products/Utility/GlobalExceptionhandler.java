package com.ecom.products.Utility;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionhandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<error> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(fieldError -> fieldError.getDefaultMessage())
                                .collect(Collectors.joining(", "));
        error apiError = new error(errorMessage, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiError, apiError.getStatusCode());
    }

    @ExceptionHandler(OrderExistsException.class)
    public ResponseEntity<error> handleOrderExists(OrderExistsException ex) {

        error apiError = new error(ex.getMessage(), HttpStatus.CONFLICT);

        return new ResponseEntity<>(apiError, apiError.getStatusCode());
    }

}
