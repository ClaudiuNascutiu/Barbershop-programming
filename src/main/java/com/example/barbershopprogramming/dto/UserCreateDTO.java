package com.example.barbershopprogramming.dto;

import com.example.barbershopprogramming.entity.Role;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDTO {

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;

    private String password;

//    private byte[] profileImage;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
