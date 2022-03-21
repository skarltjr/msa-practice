package com.msa.exception.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(int status,String errorCode,String message) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.error = errorCode;
        this.message = message;
    }
}
