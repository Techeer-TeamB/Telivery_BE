package com.telivery.persistence.user.entity;

import java.util.Collections;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserAdapter extends org.springframework.security.core.userdetails.User {

  private final User user;

  private UserAdapter(User user) {
    super(user.getUsername(), user.getPassword().getValue(),
        Collections.singleton(new SimpleGrantedAuthority(user.getRole().getAuthority())));
    this.user = user;
  }

  public static UserAdapter makeAdaptor(User user) {
    return new UserAdapter(user);
  }

  public User getAccount() {
    return user;
  }

}
