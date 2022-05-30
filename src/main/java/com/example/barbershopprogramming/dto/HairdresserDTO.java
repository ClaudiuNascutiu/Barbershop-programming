package com.example.barbershopprogramming.dto;


import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HairdresserDTO {

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;
}
