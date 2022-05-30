package com.example.barbershopprogramming.service.implementation;

import com.example.barbershopprogramming.dto.HairdresserCreateDto;
import com.example.barbershopprogramming.dto.HairdresserDTO;
import com.example.barbershopprogramming.entity.Hairdresser;
import com.example.barbershopprogramming.repository.HairdresserRepository;
import com.example.barbershopprogramming.service.HairdresserService;
import com.example.barbershopprogramming.service.mapper.HairdresserMapper;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class HaidresserServiceImpl implements HairdresserService {

    private final HairdresserRepository repository;

    private final HairdresserMapper mapper;

    public HaidresserServiceImpl(HairdresserRepository repository, HairdresserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public HairdresserDTO addHairdresser(HairdresserCreateDto addHairdresser) {
        Hairdresser toBeSaved = mapper.addHairdresser(addHairdresser);
        Hairdresser saved = repository.save(toBeSaved);

        return mapper.showHairdresser(saved);
    }

    @Override
    public HairdresserDTO updateHairdresser(HairdresserCreateDto createDto, Long id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementException("No createDto was found"));
        createDto.setId(id);
        Hairdresser toBeSaved = mapper.addHairdresser(createDto);
        Hairdresser saved = repository.save(toBeSaved);

        return mapper.showHairdresser(saved);
    }

    @Override
    public void deleteHairdresser(Long id) {
        repository.findById(id).orElseThrow(() -> new NoSuchElementException("No hairdresser was found"));
        repository.deleteById(id);
    }


}
