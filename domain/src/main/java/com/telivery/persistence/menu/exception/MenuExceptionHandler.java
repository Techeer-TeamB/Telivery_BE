package com.telivery.persistence.menu.exception;

import com.telivery.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MenuExceptionHandler {

  // menu pk가 존재하지 않을 경우의 exception
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(MenuIdNotFoundException.class)
  public ErrorResponse handleMenuIdNotFoundException(MenuIdNotFoundException ex) {
    log.info("menu id not found exception", ex);
    return new ErrorResponse(ex.getErrorCode());
  }

  // 가게에 메뉴 존재하지 않을 경우의 exception
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoMenuInRestaurantException.class)
  public ErrorResponse handleNoMenuInRestaurantException(NoMenuInRestaurantException ex) {
    log.info("NO menu in restaurant exception", ex);
    return new ErrorResponse(ex.getErrorCode());
  }

  // 메뉴에 옵션 존재하지 않을 경우의 exception
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoOptionInMenuException.class)
  public ErrorResponse handleNoOptionInMenuException(NoOptionInMenuException ex) {
    log.info("No option in menu exception", ex);
    return new ErrorResponse(ex.getErrorCode());
  }

}
