package com.telivery.common.security.jwt;

import com.google.gson.Gson;
import com.telivery.common.exception.ErrorCode;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException e
  ) throws IOException {
    // 인증에 실패한 경우(자격 증명이 유효하지 않은 경우), unauthorized response 리턴
    String exception = String.valueOf(request.getAttribute("exception"));

    // 토큰 없는 경우
    if (exception.equals(ErrorCode.TOKEN_NOT_FOUND.getCode()+"")) {
      setResponse(response, ErrorCode.TOKEN_NOT_FOUND);
    }

    // 토큰 만료된 경우
    else if (exception.equals(ErrorCode.EXPIRED_TOKEN.getCode()+"")) {
      setResponse(response, ErrorCode.EXPIRED_TOKEN);
    }

    // 기타
    else {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UnAuthorized");
    }
  }

  private void setResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
    response.setContentType("application/json;");
    response.setCharacterEncoding("UTF-8");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    JwtExceptionResponse jwtExceptionResponse = new JwtExceptionResponse(errorCode.getCode(), errorCode.getMessage());
    response.getWriter().write(new Gson().toJson(jwtExceptionResponse));
  }

}
