package com.example.barbershopprogramming.controller;

import com.example.barbershopprogramming.dto.ClientCreateDTO;
import com.example.barbershopprogramming.dto.ClientDTO;
import com.example.barbershopprogramming.entity.Client;
import com.example.barbershopprogramming.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/client")
public class ClientController {

    private final ClientService service;

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientCreateDTO createDTO){
        return ResponseEntity.ok(service.addClient(createDTO));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ClientDTO> updateClient(@RequestBody ClientCreateDTO createDTO, @PathVariable Long id){
        return ResponseEntity.ok(service.updateClient(createDTO, id));
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        service.deleteClient(id);
    }
}
