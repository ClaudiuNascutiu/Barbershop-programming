package com.example.barbershopprogramming.controller;


import com.example.barbershopprogramming.dto.HairdresserCreateDto;
import com.example.barbershopprogramming.dto.HairdresserDTO;
import com.example.barbershopprogramming.service.HairdresserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/hairdresser")
public class HairdresserController {

    private final HairdresserService service;

    @PostMapping
    public ResponseEntity<HairdresserDTO> addHairdresser(@RequestBody HairdresserCreateDto createDto) {
        return ResponseEntity.ok(service.addHairdresser(createDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HairdresserDTO> updateHairdresser(@RequestBody HairdresserCreateDto createDto,
                                                            @PathVariable Long id) {
        return ResponseEntity.ok(service.updateHairdresser(createDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteHairdresser(@PathVariable Long id) {
        service.deleteHairdresser(id);
    }
}
