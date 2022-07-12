package com.telivery.persistence.user;

import com.telivery.persistence.user.dao.UserRepository;
import com.telivery.persistence.user.dto.UserDto.UserReq;
import com.telivery.persistence.user.dto.UserDto.UserRes;
import com.telivery.persistence.user.exception.NameDuplicateException;
import com.telivery.persistence.user.exception.UsernameDuplicateException;
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
    if (userService.isExistedUsername(userReq.getID())) throw new UsernameDuplicateException();
    if (userService.isExistedName(userReq.getName())) throw new NameDuplicateException();
    return new UserRes(userRepository.save(userReq.toEntity(userReq)));
  }

}
