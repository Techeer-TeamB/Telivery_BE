package com.telivery.persistence.order.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class IsNotUserOrderException extends RuntimeException {

  private final ErrorCode errorCode;

  public IsNotUserOrderException() {
    this.errorCode = ErrorCode.IS_NOT_USER_ORDER;
  }
}
