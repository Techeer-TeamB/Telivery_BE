package com.telivery.common.security.jwt;

import com.telivery.persistence.user.dao.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    String password = "";
    String role = "";

    final Optional<com.telivery.persistence.user.entity.User> user = userRepository.findByUsername(username);
    if (user.isPresent()) {
      password = user.get().getPassword().getValue();
      role = user.get().getRole().getAuthority();
    } else throw new UsernameNotFoundException("Account [" + username + "] not found exception");

    return User
        .withUsername(username)
        .password(password)
        .authorities(new SimpleGrantedAuthority(role))
        .accountExpired(false)
        .accountLocked(false)
        .credentialsExpired(false)
        .disabled(false)
        .build();
  }

}
