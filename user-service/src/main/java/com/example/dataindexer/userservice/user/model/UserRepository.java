package com.example.dataindexer.userservice.user.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);

    Optional<User> findByUsername(String username);
}
