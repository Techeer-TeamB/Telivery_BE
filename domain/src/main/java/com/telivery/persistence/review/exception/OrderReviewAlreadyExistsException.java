package com.telivery.persistence.review.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class OrderReviewAlreadyExistsException extends RuntimeException {

  private final ErrorCode errorCode;

  public OrderReviewAlreadyExistsException() { this.errorCode = ErrorCode.ORDER_REVIEW_ALREADY_EXISTS; }

}
