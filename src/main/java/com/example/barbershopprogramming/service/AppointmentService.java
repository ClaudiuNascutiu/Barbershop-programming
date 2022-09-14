package com.example.barbershopprogramming.service;

import com.example.barbershopprogramming.dto.AppointmentCreateDTO;
import com.example.barbershopprogramming.dto.AppointmentDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {

    AppointmentDTO addAppointment(AppointmentCreateDTO appointment);

    AppointmentDTO updateAppointment(AppointmentCreateDTO appointment, Long id);

    void deleteAppointment(Long id);

    List<LocalTime> findEmptySlotsByHairdresserId(Long id, LocalDate day);

    List<AppointmentDTO> getAllAppointmentByClientId(Long id);

    List<AppointmentDTO> getAllAppointmentsAfterByHairdresserId(Long id);

    List<AppointmentDTO> getAllAppointmentsBeforeTheCurrentDateByClientId(Long id);

    List<AppointmentDTO> getAllAppointmentsAfterTheCurrentDateByClientId(Long id);

    void deleteAllAppointmentByClientId(Long clientId);
}
