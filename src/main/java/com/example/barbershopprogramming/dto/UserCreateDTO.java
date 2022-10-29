package com.example.barbershopprogramming.dto;

import com.example.barbershopprogramming.annotation.email_validator.ValidEmail;
import com.example.barbershopprogramming.annotation.password_validator.PasswordMatches;
import com.example.barbershopprogramming.entity.Role;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@PasswordMatches
public class UserCreateDTO {

    @NotNull
    @NotEmpty
    private String firstname;
    @NotNull
    @NotEmpty
    private String lastname;
    @NotNull
    @NotEmpty
    private String phoneNumber;
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
    @NotNull
    private String password;
    private String matchingPassword;

//    private byte[] profileImage;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
