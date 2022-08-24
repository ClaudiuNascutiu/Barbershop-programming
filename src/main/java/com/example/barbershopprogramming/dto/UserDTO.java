package com.example.barbershopprogramming.dto;


import com.example.barbershopprogramming.entity.Role;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private Role role;
}
