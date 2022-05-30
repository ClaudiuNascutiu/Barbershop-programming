package com.example.barbershopprogramming.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Person {

    @JoinColumn(name = "firstname")
    private String firstname;

    @JoinColumn(name = "lastname")
    private String lastname;

    @JoinColumn(name = "phone_number")
    private String phoneNumber;

    @JoinColumn(name = "email")
    private String email;

    @JoinColumn(name = "password")
    private String password;
}
