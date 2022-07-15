package com.telivery.controller.user;

import com.telivery.common.security.jwt.JwtFilter;
import com.telivery.persistence.user.AuthService;
import com.telivery.persistence.user.dto.LoginDto;
import com.telivery.persistence.user.dto.LoginDto.LoginRes;
import com.telivery.persistence.user.dto.UserDto.UserReq;
import com.telivery.persistence.user.dto.UserDto.UserRes;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping(value = "/sign-up")
  public ResponseEntity<UserRes> signUp (
      @RequestBody UserReq userReq
  ) {
    return new ResponseEntity<>(authService.create(userReq), HttpStatus.CREATED);
  }

  // 로그인
  @PostMapping("/sign-in")
  public ResponseEntity<LoginRes> logIn(
      @Valid @RequestBody LoginDto.LoginReq loginDto
  ) {
    return new ResponseEntity<>(authService.login(loginDto), HttpStatus.OK);
  }

}
