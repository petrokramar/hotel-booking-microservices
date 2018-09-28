package com.hotelbooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ApiError> dataNotFoundExceptionHandler(HttpServletRequest req, Exception exception) {
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setError("Data not found");
        apiError.setDate(LocalDateTime.now());
        apiError.setPath(req.getRequestURI());
        apiError.setStatus(404);
        apiError.setMethod(req.getMethod());
        return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> exceptionHandler(HttpServletRequest req, Exception exception) {
        ApiError apiError = new ApiError();
        apiError.setMessage(exception.getMessage());
        apiError.setError("Unknown error");
        apiError.setDate(LocalDateTime.now());
        apiError.setPath(req.getRequestURI());
        apiError.setStatus(500);
        apiError.setMethod(req.getMethod());
        return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}