package com.telivery.common.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class JwtExceptionResponse {

  private int code;
  private String message;

}
