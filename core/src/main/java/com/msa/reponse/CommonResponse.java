package com.msa.reponse;

import java.time.LocalDateTime;

public class CommonResponse<T> {
    private T data;
    private LocalDateTime timeStamp;

    public CommonResponse(T data) {
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }
}
