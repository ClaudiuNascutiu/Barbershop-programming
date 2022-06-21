package com.example.barbershopprogramming.service.mapper;

import com.example.barbershopprogramming.dto.UserCreateDTO;
import com.example.barbershopprogramming.dto.UserDTO;
import com.example.barbershopprogramming.entity.User;
import com.example.barbershopprogramming.entity.Role;
import com.example.barbershopprogramming.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

    private UserRepository userRepository;

    public User toEntity(UserCreateDTO createDTO) {
        return User.builder()
                .firstname(createDTO.getFirstname())
                .lastname(createDTO.getLastname())
                .phoneNumber(createDTO.getPhoneNumber())
                .email(createDTO.getEmail())
                .password(createDTO.getPassword())
                .role(Role.valueOf(createDTO.getRole().name()))
                .build();
    }

    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public User toEntityIgnorePassword(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .email(userDTO.getEmail())
                .password(userRepository.findById(userDTO.getId()).get().getPassword())
                .build();
    }
}
