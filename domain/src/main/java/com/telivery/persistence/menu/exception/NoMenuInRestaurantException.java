package com.telivery.persistence.menu.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class NoMenuInRestaurantException extends RuntimeException {

  private final ErrorCode errorCode;

  public NoMenuInRestaurantException() {
    this.errorCode = ErrorCode.NO_MENU_IN_RESTAURANT;
  }


}
