package com.telivery.common.security.jwt;

import com.google.gson.Gson;
import com.telivery.common.exception.ErrorCode;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

// DESCRIBE: 필터링 중 발생하는 사용자 권한 예외를 처리
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException accessDeniedException) throws IOException, ServletException {
    setResponse(response, ErrorCode.ACCOUNT_ACCESS_DENIED);
  }

  private void setResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
    response.setContentType("application/json;");
    response.setCharacterEncoding("UTF-8");
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    JwtExceptionResponse jwtExceptionResponse = new JwtExceptionResponse(errorCode.getCode(), errorCode.getMessage());
    response.getWriter().write(new Gson().toJson(jwtExceptionResponse));
  }

}
