package com.telivery.persistence.user.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CustomInterAuthenticationServiceException extends RuntimeException {

  private final ErrorCode errorCode;

  public CustomInterAuthenticationServiceException() { this.errorCode = ErrorCode.INTERNAL_AUTHENTICATE_FAILED; }


}
