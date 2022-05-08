package com.telivery.persistence.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telivery.common.exception.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class UserExceptionHandler {

    // ExceptionHandler 어노테이션을 사용, 전역에서 Exceptiond을 핸들링할 수 있게 처리합니다.
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
        // exception throw가 발생할 경우 log를 납깁니다.
        log.info("account not found exception", ex);
        return new ErrorResponse(ex.getErrorStatus());
    }

}
