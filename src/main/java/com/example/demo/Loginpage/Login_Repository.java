package com.example.demo.Loginpage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Login_Repository extends JpaRepository<Login_Entity,Long> {
    Optional<Login_Entity> findByEmail(String email);

    boolean existsByEmail(String email);
}
