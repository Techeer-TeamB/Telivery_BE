package com.telivery.persistence.user.dto;

import com.telivery.persistence.user.entity.Password;
import com.telivery.persistence.user.entity.Role;
import com.telivery.persistence.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class UserDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class UserReq {

    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User toEntity(UserReq userReq) {
      Password newPassword = Password.builder().password(userReq.getPassword()).build();
      return User.builder()
          .username(userReq.getUsername())
          .password(newPassword)
          .role(Role.ROLE_USER)
          .name(userReq.getName())
          .email(userReq.getEmail())
          .phone(userReq.getPhone())
          .build();
    }

  }

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class UserRes {

    private String username;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String grade;
    private Integer point;

    public UserRes(User user) {
      this.username = user.getUsername();
      this.name = user.getName();
      this.email = user.getEmail();
      this.phone = user.getPhone();
      this.address = user.getAddress();
      this.grade = user.getGrade();
      this.point = user.getPoint();
    }

  }


}
