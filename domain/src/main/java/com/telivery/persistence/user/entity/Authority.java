package com.telivery.persistence.user.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
  ROLE_ADMIN,
  ROLE_USER;

  public String getAuthority() { return name(); }
}
