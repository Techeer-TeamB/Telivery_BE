package com.telivery.persistence.user.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LoginDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class LoginReq {

    private String username;

    private String password;

  }

  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class LoginRes {

    private String accessToken;

  }

}
