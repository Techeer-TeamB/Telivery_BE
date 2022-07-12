package com.telivery.persistence.user.dao;

import com.telivery.persistence.user.entity.User;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    boolean existsByUsername(String username);
    boolean existsByName(String name);
}
