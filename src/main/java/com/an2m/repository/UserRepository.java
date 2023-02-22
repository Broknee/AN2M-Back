package com.an2m.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.an2m.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
