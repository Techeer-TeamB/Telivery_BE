package com.telivery.persistence.time.exceptioin;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class TimeNotFoundException extends RuntimeException {

  private final ErrorCode errorCode;

  public TimeNotFoundException() { this.errorCode = ErrorCode.TIME_NOT_FOUND; }

}
