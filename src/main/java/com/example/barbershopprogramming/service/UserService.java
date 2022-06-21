package com.example.barbershopprogramming.service;

import com.example.barbershopprogramming.dto.UserCreateDTO;
import com.example.barbershopprogramming.dto.UserDTO;
import com.example.barbershopprogramming.entity.Role;
import com.example.barbershopprogramming.entity.User;

import java.util.List;

public interface UserService {

    UserDTO addUser(UserCreateDTO createDTO);

    UserDTO updateUser(UserDTO userDTO);

    List<User> getAllUsers(Role role);

    void deleteUser(Long id);

    UserDTO getByEmail(String email);
}
