package com.telivery.persistence.user.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class UsernameDuplicateException extends RuntimeException {
  private final ErrorCode errorCode;

  public UsernameDuplicateException() { this.errorCode = ErrorCode.USERNAME_DUPLICATE; }

}
