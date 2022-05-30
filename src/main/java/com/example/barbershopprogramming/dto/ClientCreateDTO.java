package com.example.barbershopprogramming.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientCreateDTO {

    private Long id;

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;

    private String password;
}
