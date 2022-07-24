package com.telivery.persistence.order.exception;

import com.telivery.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class OrderExceptionHandler {

  // order pk가 존재하지 않을 경우의 exception
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(OrderIdNotFoundException.class)
  public ErrorResponse handleOrderIdNotFoundException(OrderIdNotFoundException ex) {
    log.info("order id not found exception", ex);
    return new ErrorResponse(ex.getErrorCode());
  }

}
