package com.telivery.persistence.user.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telivery.common.response.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class UserExceptionHandler {

    // ExceptionHandler 어노테이션을 사용, 전역에서 Exception을 핸들링할 수 있게 처리합니다.
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
        // exception throw가 발생할 경우 log를 납깁니다.
        log.info("account not found exception", ex);
        return new ErrorResponse(ex.getErrorCode());
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(UsernameDuplicateException.class)
    public ErrorResponse handleUsernameDuplicateException(UsernameDuplicateException ex) {
        log.info("username duplicate exception", ex);
        return new ErrorResponse(ex.getErrorCode());
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(NameDuplicateException.class)
    public ErrorResponse handleNameDuplicateException(NameDuplicateException ex) {
        log.info("name duplicate exception", ex);
        return new ErrorResponse(ex.getErrorCode());
    }

}
