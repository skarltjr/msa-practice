package com.msa.domain.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private final String message;
    private final int status;

    public UserNotFoundException(int status,String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
