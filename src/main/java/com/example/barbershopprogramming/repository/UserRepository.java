package com.example.barbershopprogramming.repository;

import com.example.barbershopprogramming.entity.Role;
import com.example.barbershopprogramming.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByRole(Role role);
}