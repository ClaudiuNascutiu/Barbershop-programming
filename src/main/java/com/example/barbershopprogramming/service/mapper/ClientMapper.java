package com.example.barbershopprogramming.service.mapper;

import com.example.barbershopprogramming.dto.ClientCreateDTO;
import com.example.barbershopprogramming.dto.ClientDTO;
import com.example.barbershopprogramming.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client addClient(ClientCreateDTO createDTO) {
        return Client.builder()
                .id(createDTO.getId())
                .firstname(createDTO.getFirstname())
                .lastname(createDTO.getLastname())
                .phoneNumber(createDTO.getPhoneNumber())
                .email(createDTO.getEmail())
                .password(createDTO.getPassword())
                .build();
    }

    public ClientDTO showClient(Client client) {
        return ClientDTO.builder()
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .phoneNumber(client.getPhoneNumber())
                .email(client.getEmail())
                .build();
    }
}
