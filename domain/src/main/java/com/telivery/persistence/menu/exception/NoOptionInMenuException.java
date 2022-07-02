package com.telivery.persistence.menu.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NoOptionInMenuException extends RuntimeException {

  private final ErrorCode errorCode;

  public NoOptionInMenuException() {
    this.errorCode = ErrorCode.NO_OPTION_IN_MENU;
  }

}
