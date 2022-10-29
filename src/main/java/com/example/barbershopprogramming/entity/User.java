package com.example.barbershopprogramming.entity;

import com.example.barbershopprogramming.annotation.email_validator.ValidEmail;
import com.example.barbershopprogramming.annotation.password_validator.PasswordMatches;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@PasswordMatches
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @NotEmpty
    private String password;
    private String matchingPassword;

//    @Lob
//    private byte[] profileImage;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

}
