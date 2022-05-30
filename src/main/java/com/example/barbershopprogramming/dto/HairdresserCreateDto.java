package com.example.barbershopprogramming.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HairdresserCreateDto {

    private Long id;

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;

    private String password;

}
