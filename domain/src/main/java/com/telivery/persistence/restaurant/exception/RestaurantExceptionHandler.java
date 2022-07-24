package com.telivery.persistence.restaurant.exception;

import com.telivery.common.response.ErrorResponse;
import com.telivery.persistence.menu.exception.MenuIdNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestaurantExceptionHandler {

  // restaurant pk가 존재하지 않을 경우의 exception
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(RestaurantIdNotFoundException.class)
  public ErrorResponse handleRestaurantIdNotFoundException(RestaurantIdNotFoundException ex) {
    log.info("restaurant id not found exception", ex);
    return new ErrorResponse(ex.getErrorCode());
  }

}
