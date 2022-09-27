package com.example.barbershopprogramming.entity;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String phoneNumber;

    private String email;

    private String password;

//    @Lob
//    private byte[] profileImage;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

}
