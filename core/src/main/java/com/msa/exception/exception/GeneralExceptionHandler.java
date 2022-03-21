package com.msa.exception.exception;

import com.msa.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    private static final String INTERNAL_SERVER_EXCEPTION_ERROR_CODE = "INTERNAL-001";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InternalServerErrorException.class)
    public ErrorResponse handleInternalServerErrorException(InternalServerErrorException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getStatus(), INTERNAL_SERVER_EXCEPTION_ERROR_CODE, e.getMessage());
        return errorResponse;
    }
}
