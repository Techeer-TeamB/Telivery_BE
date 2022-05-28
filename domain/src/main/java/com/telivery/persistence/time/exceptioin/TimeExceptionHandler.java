package com.telivery.persistence.time.exceptioin;

import com.telivery.common.exception.global.BadRequestException;
import com.telivery.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class TimeExceptionHandler {

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(TimeNotFoundException.class)
  public ErrorResponse handleTimeNotFoundException(TimeNotFoundException ex) {
    log.info("time not found exception", ex);
    return new ErrorResponse(ex.getErrorCode());
  }

}
