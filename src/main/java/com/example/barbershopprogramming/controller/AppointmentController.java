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

    @DeleteMapping()
    public void deleteAppointment(@RequestParam Long id) {
        service.deleteAppointment(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllAppointmentsByClientId(@RequestParam Long id) {
        service.deleteAllAppointmentByClientId(id);
    }

    @GetMapping("/available-slots")
    public ResponseEntity<List<LocalTime>> getAvailableSlots(@RequestParam Long id,
                                                             @RequestParam
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                                                                     fallbackPatterns = "dd-mm-yyyy") LocalDate day) {
        return ResponseEntity.ok(service.findEmptySlotsByHairdresserId(id, day));
    }

    @GetMapping("/client")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointmentByClientId(@RequestParam Long id) {
        return ResponseEntity.ok(service.getAllAppointmentByClientId(id));
    }

    @GetMapping("/hairdresser")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointmentByHairdresserId(@RequestParam Long id) {
        return ResponseEntity.ok(service.getAllAppointmentsAfterByHairdresserId(id));
    }

    @GetMapping("/before")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointmentBeforeTheCurrentDateByClientId(@RequestParam Long id) {
        return ResponseEntity.ok(service.getAllAppointmentsBeforeTheCurrentDateByClientId(id));
    }

    @GetMapping("/after")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointmentAfterTheCurrentDateByClientId(@RequestParam Long id) {
        return ResponseEntity.ok(service.getAllAppointmentsAfterTheCurrentDateByClientId(id));
    }


}
