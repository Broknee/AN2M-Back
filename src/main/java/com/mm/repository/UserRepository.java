package com.mm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
