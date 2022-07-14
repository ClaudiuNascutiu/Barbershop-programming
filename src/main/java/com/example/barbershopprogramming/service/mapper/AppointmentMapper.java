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
                .id(appointment.getId())
                .day(appointment.getDay())
                .startTime(appointment.getStartTime())
                .hairdresserName(appointment.getHairdresser().getFirstname())
                .hairdresserLastName(appointment.getHairdresser().getLastname())
                .hairdresserPhone(appointment.getHairdresser().getPhoneNumber())
                .hairdresserEmail(appointment.getHairdresser().getEmail())
                .build();
    }

    public AppointmentDTO toDTOForHairdresser(Appointment appointment) {
        return AppointmentDTO.builder()
                .id(appointment.getId())
                .day(appointment.getDay())
                .startTime(appointment.getStartTime())
                .clientName(appointment.getClient().getFirstname())
                .clientLastName(appointment.getClient().getLastname())
                .clientPhone(appointment.getClient().getPhoneNumber())
                .clientEmail(appointment.getClient().getEmail())
                .build();
    }
}
