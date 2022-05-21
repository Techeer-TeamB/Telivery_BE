package com.telivery.persistence.user.entity;

import com.telivery.persistence.user.entity.type.Role;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @CreatedDate
    @Column(name="createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updatedAt")
    private Date updatedAt;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name="role")
    private Role role;
}
