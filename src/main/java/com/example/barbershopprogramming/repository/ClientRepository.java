package com.example.barbershopprogramming.repository;

import com.example.barbershopprogramming.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
