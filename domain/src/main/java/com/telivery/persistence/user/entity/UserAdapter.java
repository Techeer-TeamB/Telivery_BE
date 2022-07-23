package com.telivery.persistence.user.entity;

import java.util.Collections;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserAdapter extends org.springframework.security.core.userdetails.User {

  private static final long serialVersionUID = 1L;
  private final User account;

  private UserAdapter(User user) {
    super(user.getUsername(), user.getPassword().getValue(),
        Collections.singleton(new SimpleGrantedAuthority(user.getRole().getAuthority())));
    this.account = user;
  }

  public static UserAdapter makeAdaptor(User user) {
    return new UserAdapter(user);
  }

  public User getAccount() {
    return account;
  }

}
