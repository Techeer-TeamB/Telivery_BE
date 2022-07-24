package com.telivery.persistence.review.exception;

import com.telivery.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ReviewExceptionHandler {

  // 요청 주문에 대한 리뷰가 이미 존재하는 경우의 exception
  @ResponseStatus(value = HttpStatus.CONFLICT)
  @ExceptionHandler(OrderReviewAlreadyExistsException.class)
  public ErrorResponse handleReviewAlreadyExistsException(OrderReviewAlreadyExistsException ex) {
    log.info("order review already exists exception", ex);
    return new ErrorResponse(ex.getErrorCode());
  }

}
