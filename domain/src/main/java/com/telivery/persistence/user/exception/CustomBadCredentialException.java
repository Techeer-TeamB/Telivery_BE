package com.telivery.persistence.user.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CustomBadCredentialException extends RuntimeException {

  private final ErrorCode errorCode;

  public CustomBadCredentialException() { this.errorCode = ErrorCode.INPUT_PASSWORD_WRONG; }

}
