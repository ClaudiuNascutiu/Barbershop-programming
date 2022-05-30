package com.example.barbershopprogramming.service.mapper;

import com.example.barbershopprogramming.dto.HairdresserCreateDto;
import com.example.barbershopprogramming.dto.HairdresserDTO;
import com.example.barbershopprogramming.entity.Hairdresser;
import org.springframework.stereotype.Component;

@Component
public class HairdresserMapper {


    public Hairdresser addHairdresser(HairdresserCreateDto createDto) {
        return Hairdresser.builder()
                .id(createDto.getId())
                .firstname(createDto.getFirstname())
                .lastname(createDto.getLastname())
                .phoneNumber(createDto.getPhoneNumber())
                .email(createDto.getEmail())
                .password(createDto.getPassword())
                .build();
    }

    public HairdresserDTO showHairdresser(Hairdresser hairdresser) {
        return HairdresserDTO.builder()
                .firstname(hairdresser.getFirstname())
                .lastname(hairdresser.getLastname())
                .phoneNumber(hairdresser.getPhoneNumber())
                .email(hairdresser.getEmail())
                .build();
    }
}
