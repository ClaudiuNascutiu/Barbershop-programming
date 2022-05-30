package com.example.barbershopprogramming.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientDTO {

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;
}
