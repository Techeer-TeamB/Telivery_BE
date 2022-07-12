package com.telivery.persistence.user;

import com.telivery.persistence.user.dao.UserRepository;
import com.telivery.persistence.user.dto.UserDto.UserReq;
import com.telivery.persistence.user.dto.UserDto.UserRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserService userService;
  private final UserRepository userRepository;

  // DESCRIBE: 새로운 user 생성 - 회원가입
  @Transactional
  public UserRes create(UserReq userReq) {
    if (userService.isExistedUsername(userReq.getID())) throw new DuplicateAccountUsernameException();
    if (userService.isExistedName(userReq.getName())) throw new DuplicateAccountUsernameException();
    return new UserRes(userRepository.save(userReq.toEntity(userReq)));
  }

}
