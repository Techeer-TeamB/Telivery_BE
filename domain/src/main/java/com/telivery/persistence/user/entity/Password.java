package com.telivery.persistence.user.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {

  @Column(name = "password", nullable = false)
  private String value;

  @Builder
  public Password(final String value) {
    this.value = value;
  }

  public void encodePassword(final String password) {
    this.value = new BCryptPasswordEncoder().encode(password);
  }

  public boolean isMatched(final String rawPassword) {
    return new BCryptPasswordEncoder().matches(rawPassword, this.value);
  }
}
