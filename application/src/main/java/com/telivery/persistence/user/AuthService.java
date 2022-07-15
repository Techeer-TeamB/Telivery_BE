package com.telivery.persistence.user;

import com.telivery.common.security.jwt.JwtProvider;
import com.telivery.persistence.user.dao.UserRepository;
import com.telivery.persistence.user.dto.LoginDto.LoginReq;
import com.telivery.persistence.user.dto.LoginDto.LoginRes;
import com.telivery.persistence.user.dto.UserDto.UserReq;
import com.telivery.persistence.user.dto.UserDto.UserRes;
import com.telivery.persistence.user.exception.CustomBadCredentialException;
import com.telivery.persistence.user.exception.CustomInterAuthenticationServiceException;
import com.telivery.persistence.user.exception.NameDuplicateException;
import com.telivery.persistence.user.exception.UserNotFoundException;
import com.telivery.persistence.user.exception.UsernameDuplicateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserService userService;
  private final UserRepository userRepository;
  private final JwtProvider jwtProvider;
  private final AuthenticationManager authenticationManager;

  // DESCRIBE: 새로운 user 생성 - 회원가입
  public UserRes create(UserReq userReq) {
    if (userService.isExistedUsername(userReq.getUsername())) throw new UsernameDuplicateException();
    if (userService.isExistedName(userReq.getName())) throw new NameDuplicateException();
    return new UserRes(userRepository.save(userReq.toEntity(userReq)));
  }

  // DESCRIBE: 로그인
  @Transactional(readOnly = true)
  public LoginRes login(LoginReq loginDto) {
    String username = loginDto.getUsername();
    String password = loginDto.getPassword();

    userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

    try {
      // AuthenticationManager에 token 넘겨서 UserDetailService가 확인하게 처리
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, password)
      );
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtProvider.generateAccessToken(authentication);
      return new LoginRes(jwt);

    } catch (BadCredentialsException e) {
      throw new CustomBadCredentialException();
    } catch (InternalAuthenticationServiceException e) {
      throw new CustomInterAuthenticationServiceException();
    }
  }

}
