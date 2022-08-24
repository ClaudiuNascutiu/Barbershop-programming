package com.example.barbershopprogramming.service.implementation;

import com.example.barbershopprogramming.dto.UserCreateDTO;
import com.example.barbershopprogramming.dto.UserDTO;
import com.example.barbershopprogramming.entity.Role;
import com.example.barbershopprogramming.entity.User;
import com.example.barbershopprogramming.repository.UserRepository;
import com.example.barbershopprogramming.service.UserService;
import com.example.barbershopprogramming.service.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }
    @Override
    public UserDTO addUser(UserCreateDTO createDTO) {
        User toBeSaved = mapper.toEntity(createDTO);
        toBeSaved.setPassword(encoder.encode(toBeSaved.getPassword()));
        User saved = repository.save(toBeSaved);

        return mapper.toDTO(saved);
    }
    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        repository.findById(userDTO.getId()).orElseThrow(() -> new NoSuchElementException("No client was found"));
        User toBeSaved = mapper.toEntityIgnorePassword(userDTO);
        User saved = repository.save(toBeSaved);

        return mapper.toDTO(saved);
    }

    @Override
    public List<User> getAllUsers(Role role) {
        return repository.findByRole(role);
    }


    @Override
    public void deleteUser(Long id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementException("No client was found"));
        repository.deleteById(id);
    }

    @Override
    public UserDTO getByEmail(String email) {
        return mapper.toDTO(repository.findByEmail(email));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return mapper.toDTO(repository.getById(id));
    }


}
