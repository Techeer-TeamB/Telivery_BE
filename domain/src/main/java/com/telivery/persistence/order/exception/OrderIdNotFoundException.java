package com.telivery.persistence.order.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class OrderIdNotFoundException extends RuntimeException {

  private final ErrorCode errorCode;

  public OrderIdNotFoundException() { this.errorCode = ErrorCode.ORDER_ID_NOT_FOUND; }
}
