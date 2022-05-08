package com.telivery.common.response;

import com.telivery.common.exception.ErrorStatus;
import lombok.Builder;
import lombok.Getter;

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
