package com.example.barbershopprogramming.controller;

import com.example.barbershopprogramming.dto.ClientCreateDTO;
import com.example.barbershopprogramming.dto.ClientDTO;
import com.example.barbershopprogramming.entity.Client;
import com.example.barbershopprogramming.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientCreateDTO createDTO){
        ClientDTO addClient = service.addClient(createDTO);
        return ResponseEntity.ok(addClient);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ClientDTO> updateClient(@RequestBody ClientCreateDTO createDTO, @PathVariable Long id){
        ClientDTO updateClient = service.updateClient(createDTO, id);
        return ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        service.deleteClient(id);
    }
}
