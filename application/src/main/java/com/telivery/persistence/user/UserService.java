package com.telivery.persistence.user;

import com.telivery.persistence.user.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public boolean isExistedUsername(String username) {
    return userRepository.existsByUsername(username);
  }

  public boolean isExistedName(String name) {
    return userRepository.existsByName(name);
  }


}
