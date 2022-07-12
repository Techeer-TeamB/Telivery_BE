package com.telivery.persistence.user.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NameDuplicateException extends RuntimeException {
  private final ErrorCode errorCode;

  public NameDuplicateException() { this.errorCode = ErrorCode.NAME_DUPLICATE; }

}
