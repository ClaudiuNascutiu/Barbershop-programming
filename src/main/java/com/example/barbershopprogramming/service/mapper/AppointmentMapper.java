package com.example.barbershopprogramming.service.mapper;

import com.example.barbershopprogramming.dto.AppointmentCreateDTO;
import com.example.barbershopprogramming.dto.AppointmentDTO;
import com.example.barbershopprogramming.entity.Appointment;
import com.example.barbershopprogramming.repository.ClientRepository;
import com.example.barbershopprogramming.repository.HairdresserRepository;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    HairdresserRepository hairdresserRepository;
    ClientRepository clientRepository;

    public Appointment toEntity(AppointmentCreateDTO createDTO) {
        return Appointment.builder()
                .id(createDTO.getId())
                .day(createDTO.getDay())
                .startTime(createDTO.getStartTime())
                .hairdresser(hairdresserRepository.getReferenceById(createDTO.getHairdresserId()))
                .client(clientRepository.getReferenceById(createDTO.getClientId()))
                .build();
    }

    public AppointmentDTO toDTO(Appointment appointment) {
        return AppointmentDTO.builder()
                .day(appointment.getDay())
                .startTime(appointment.getStartTime())
                .build();
    }
}
