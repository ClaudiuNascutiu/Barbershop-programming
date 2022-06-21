package com.example.barbershopprogramming.service.mapper;

import com.example.barbershopprogramming.dto.AppointmentCreateDTO;
import com.example.barbershopprogramming.dto.AppointmentDTO;
import com.example.barbershopprogramming.entity.Appointment;
import com.example.barbershopprogramming.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppointmentMapper {
    UserRepository userRepository;

    public Appointment toEntity(AppointmentCreateDTO createDTO) {
        return Appointment.builder()
                .id(createDTO.getId())
                .day(createDTO.getDay())
                .startTime(createDTO.getStartTime())
                .hairdresser(userRepository.getById(createDTO.getHairdresserId()))
                .client(userRepository.getById(createDTO.getClientId()))
                .build();
    }

    public AppointmentDTO toDTO(Appointment appointment) {
        return AppointmentDTO.builder()
                .day(appointment.getDay())
                .startTime(appointment.getStartTime())
                .build();
    }
}
