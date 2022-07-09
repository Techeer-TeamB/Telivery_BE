package com.telivery.persistence.user.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
}
