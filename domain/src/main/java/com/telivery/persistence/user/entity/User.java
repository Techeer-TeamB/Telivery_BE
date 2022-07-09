package com.telivery.persistence.user.entity;

import com.telivery.common.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String username;

    @Column(length = 13)
    private String phone;

    @Column()
    private String email;

    @Column()
    private String address;

    @Column(length = 20, name = "class")
    private String gradle;

    private Integer point;

    private Float lat;

    private Float lng;

}
