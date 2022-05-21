package com.telivery.persistence.auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SignUpDto {
    private String email;

    private String password;

    private String username;

    private Date birthday;

    private String phoneNumber;
}
