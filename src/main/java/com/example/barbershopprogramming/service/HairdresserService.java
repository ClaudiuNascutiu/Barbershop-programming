package com.example.barbershopprogramming.service;

import com.example.barbershopprogramming.dto.HairdresserCreateDto;
import com.example.barbershopprogramming.dto.HairdresserDTO;

public interface HairdresserService {

    HairdresserDTO addHairdresser(HairdresserCreateDto addHairdresser);

    HairdresserDTO updateHairdresser(HairdresserCreateDto hairdresser, Long id);

    void deleteHairdresser(Long id);
}
