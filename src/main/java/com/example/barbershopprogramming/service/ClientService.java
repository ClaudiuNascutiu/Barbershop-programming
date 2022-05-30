package com.example.barbershopprogramming.service;

import com.example.barbershopprogramming.dto.ClientCreateDTO;
import com.example.barbershopprogramming.dto.ClientDTO;

public interface ClientService {

    ClientDTO addClient(ClientCreateDTO createDTO);

    ClientDTO updateClient(ClientCreateDTO createDTO, Long id);

    void deleteClient(Long id);
}
