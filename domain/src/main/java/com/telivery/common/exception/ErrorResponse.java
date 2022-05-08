package com.telivery.common.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {

    private int code;
    private String message;

    @Builder
    public ErrorResponse(ErrorStatus errorStatus) {
        this.code = errorStatus.getCode();
        this.message = errorStatus.getMessage();
    }
}
