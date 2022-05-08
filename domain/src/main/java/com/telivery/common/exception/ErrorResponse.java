package com.telivery.common.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private int status;
    private String message;

    @Builder
    public ErrorResponse(ErrorStatus errorStatus) {
        this.status = errorStatus.getStatus();
        this.message = errorStatus.getMessage();
    }
}
