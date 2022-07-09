package com.telivery.common.security.jwt;

import com.telivery.common.exception.ErrorCode;
import io.jsonwebtoken.JwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

  private final JwtProvider jwtTokenProvider;

  public static final String AUTHORIZATION_HEADER = "Authorization";

  @Override
  public void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {

    // header에서 accessToken 확인
    String accessToken = jwtTokenProvider.resolveToken(httpServletRequest);
    if (accessToken != null) {
      // Access Token이 만료된 경우
      if (jwtTokenProvider.isTokenExpired(accessToken)) {
        httpServletRequest.setAttribute("exception", ErrorCode.EXPIRED_TOKEN.getCode());
        throw new JwtException("access token already expired");
      }

      // Access Token 이 유효한데 권한이 아직 없다면
      else if (jwtTokenProvider.validateToken(accessToken)
          && SecurityContextHolder.getContext().getAuthentication() == null) {
        Authentication auth = jwtTokenProvider.getAuthentication(accessToken);
        // 토큰에 권한 부여한 후 securityContext에 저장
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    }

  }

}
