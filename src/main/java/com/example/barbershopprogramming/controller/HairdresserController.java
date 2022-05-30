package com.example.barbershopprogramming.controller;


import com.example.barbershopprogramming.dto.HairdresserCreateDto;
import com.example.barbershopprogramming.dto.HairdresserDTO;
import com.example.barbershopprogramming.service.HairdresserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/hairdresser")
public class HairdresserController {

    private final HairdresserService service;

    public HairdresserController(HairdresserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HairdresserDTO> addHairdresser(@RequestBody HairdresserCreateDto createDto) {
        HairdresserDTO addHairdresser = service.addHairdresser(createDto);
        return ResponseEntity.ok(addHairdresser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HairdresserDTO> updateHairdresser(@RequestBody HairdresserCreateDto createDto,
                                                            @PathVariable Long id) {
        HairdresserDTO updateHairdresser = service.updateHairdresser(createDto, id);
        return ResponseEntity.ok(updateHairdresser);
    }

    @DeleteMapping("/{id}")
    public void deleteHairdresser(@PathVariable Long id) {
        service.deleteHairdresser(id);
    }
}
