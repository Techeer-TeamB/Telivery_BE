package com.telivery.common.exception.global;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private final ErrorCode errorCode;

    public BadRequestException() { this.errorCode = ErrorCode.OMISSION_REQUIRE_PARAM; }
}
