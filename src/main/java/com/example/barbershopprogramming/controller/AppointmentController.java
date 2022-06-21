package com.example.barbershopprogramming.controller;

import com.example.barbershopprogramming.dto.AppointmentCreateDTO;
import com.example.barbershopprogramming.dto.AppointmentDTO;
import com.example.barbershopprogramming.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    private AppointmentService service;


    @PostMapping
    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody AppointmentCreateDTO appointment) {
        return ResponseEntity.ok(service.addAppointment(appointment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentCreateDTO appointment,
                                                            @PathVariable Long id) {

        return ResponseEntity.ok(service.updateAppointment(appointment, id));
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        service.deleteAppointment(id);
    }

    @GetMapping("/{id}/{day}")
    public ResponseEntity<List<LocalTime>> getAvailableSlots(@PathVariable Long id,
                                                             @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate day){
       return ResponseEntity.ok(service.findEmptySlotsByHairdresserId(id, day));
    }

}
