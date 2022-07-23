package com.telivery.persistence.user.entity;

import com.telivery.common.domain.BaseEntity;
import io.jsonwebtoken.Claims;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@Builder
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name = "role")
    Role role;

    @Column(length = 30)
    private String name;

    @Column(length = 30, unique = true, nullable = false)
    private String username;

    @Embedded
    private Password password;

    @Column(length = 13)
    private String phone;

    @Column()
    private String email;

    @Column()
    private String address;

    @Column(length = 20, name = "class")
    private String grade;

    private Integer point;

    private Float lat;

    private Float lng;

}
