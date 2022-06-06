package com.example.barbershopprogramming.entity;

import com.sun.istack.NotNull;
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

    @NotNull
    @JoinColumn(name = "firstname")
    private String firstname;

    @NotNull
    @JoinColumn(name = "lastname")
    private String lastname;

    @NotNull
    @JoinColumn(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @JoinColumn(name = "email")
    private String email;

    @NotNull
    @JoinColumn(name = "password")
    private String password;
}
