package com.msa.exception.exception;

import lombok.Getter;

@Getter
public class InternalServerErrorException extends RuntimeException {
    private final int status;
    private final String message;

    public InternalServerErrorException(int status,String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
