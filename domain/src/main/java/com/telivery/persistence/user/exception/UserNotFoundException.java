package com.telivery.persistence.user.exception;

import com.telivery.common.exception.ErrorStatus;
import lombok.Getter;

// 예시 커스텀 exception 입니다.
@Getter
public class UserNotFoundException extends RuntimeException {

    private final ErrorStatus errorStatus;

    public UserNotFoundException() { this.errorStatus = ErrorStatus.USER_NOT_FOUND; }


}
