package com.myapp.app.repository;

import com.myapp.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findById(Long userId);

    Optional<User> findByUsername(String username);

//    User saveUser(User user);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}