package com.an2m.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.an2m.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
