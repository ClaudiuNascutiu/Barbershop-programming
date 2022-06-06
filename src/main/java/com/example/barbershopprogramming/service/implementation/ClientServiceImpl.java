package com.example.barbershopprogramming.service.implementation;

import com.example.barbershopprogramming.dto.ClientCreateDTO;
import com.example.barbershopprogramming.dto.ClientDTO;
import com.example.barbershopprogramming.entity.Client;
import com.example.barbershopprogramming.repository.ClientRepository;
import com.example.barbershopprogramming.service.ClientService;
import com.example.barbershopprogramming.service.mapper.ClientMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    private final ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ClientDTO addClient(ClientCreateDTO createDTO) {
        Client toBeSaved = mapper.toEntity(createDTO);
        Client saved = repository.save(toBeSaved);

        return mapper.toDTO(saved);
    }

    @Override
    public ClientDTO updateClient(ClientCreateDTO createDTO, Long id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementException("No client was found"));
        createDTO.setId(id);
        Client toBeSaved = mapper.toEntity(createDTO);
        Client saved = repository.save(toBeSaved);

        return mapper.toDTO(saved);
    }

    @Override
    public void deleteClient(Long id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementException("No client was found"));
        repository.deleteById(id);
    }


}
