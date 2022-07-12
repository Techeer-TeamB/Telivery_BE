package com.telivery.controller.user;

import com.telivery.persistence.user.AuthService;
import com.telivery.persistence.user.dto.UserDto.UserReq;
import com.telivery.persistence.user.dto.UserDto.UserRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @GetMapping(value = "/sign-up")
  public ResponseEntity<UserRes> signUp (
      @RequestBody UserReq userReq
  ) {
    return new ResponseEntity<>(authService.create(userReq), HttpStatus.CREATED);
  }

}
