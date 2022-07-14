package com.example.barbershopprogramming.controller;

import com.example.barbershopprogramming.dto.UserCreateDTO;
import com.example.barbershopprogramming.dto.UserDTO;
import com.example.barbershopprogramming.entity.Role;
import com.example.barbershopprogramming.entity.User;
import com.example.barbershopprogramming.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService service;

    @PostMapping("/client/signup")
    public ResponseEntity<UserDTO> addClient(@RequestBody UserCreateDTO createDTO){
        createDTO.setRole(Role.CLIENT);
        return ResponseEntity.ok(service.addUser(createDTO));
    }

    @PostMapping("/hairdresser/signup")
    public ResponseEntity<UserDTO> addHairdresser(@RequestBody UserCreateDTO createDTO){
        createDTO.setRole(Role.HAIRDRESSER);
        return ResponseEntity.ok(service.addUser(createDTO));
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserCreateDTO createDTO){
        return ResponseEntity.ok(service.getByEmail(createDTO.getEmail()));
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam Role role){
        return ResponseEntity.ok(service.getAllUsers(role));
    }


    @PutMapping
    public  ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(service.updateUser(userDTO));
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long id){
        service.deleteUser(id);
    }
}
