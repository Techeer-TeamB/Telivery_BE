package com.telivery.persistence.user.dto;

import com.telivery.persistence.user.entity.Password;
import com.telivery.persistence.user.entity.Role;
import com.telivery.persistence.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCreateDto {

  private String ID;
  private String password;
  private String name;
  private String email;
  private String phone;

  public User toEntity(UserCreateDto userCreateDto) {
    Password newPassword = Password.builder().password(userCreateDto.getPassword()).build();
    return User.builder()
        .username(userCreateDto.getID())
        .password(newPassword)
        .role(Role.ROLE_USER)
        .name(userCreateDto.getName())
        .email(userCreateDto.getEmail())
        .phone(userCreateDto.getPhone())
        .build();
  }

}
