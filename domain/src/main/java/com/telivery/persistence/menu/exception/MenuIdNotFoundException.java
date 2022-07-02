package com.telivery.persistence.menu.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class MenuIdNotFoundException extends RuntimeException {

  private final ErrorCode errorCode;

  public MenuIdNotFoundException() {
    this.errorCode = ErrorCode.MENU_ID_NOT_FOUND;
  }


}
