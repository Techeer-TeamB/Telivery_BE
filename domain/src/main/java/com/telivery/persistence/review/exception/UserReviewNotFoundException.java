package com.telivery.persistence.review.exception;

import com.telivery.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class UserReviewNotFoundException extends RuntimeException{

  private final ErrorCode errorCode;

  public UserReviewNotFoundException() { this.errorCode = ErrorCode.USER_REVIEW_NOT_FOUND; }

}
