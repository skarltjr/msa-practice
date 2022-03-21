package com.msa.infrastructure;

import com.msa.domain.exception.UserNotFoundException;
import com.msa.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserExceptionHandler {
    private static final String USER_NOT_FOUND_ERROR_CODE = "USER-001";


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleUserNotFoundException(UserNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getStatus(), USER_NOT_FOUND_ERROR_CODE, e.getMessage());
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }
}
