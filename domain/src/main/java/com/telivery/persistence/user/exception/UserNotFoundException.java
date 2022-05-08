package com.telivery.persistence.user.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

// 예시 커스텀 exception 입니다.
@Getter
public class UserNotFoundException extends RuntimeException {

    private final ErrorCode errorStatus;

    public UserNotFoundException() { this.errorStatus = ErrorCode.USER_NOT_FOUND; }


}
