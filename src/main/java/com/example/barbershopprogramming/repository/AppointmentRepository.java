package com.example.barbershopprogramming.repository;

import com.example.barbershopprogramming.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByHairdresserIdAndDay(Long id, LocalDate day);

    List<Appointment> findAllByClientId(Long id);

    List<Appointment> findAllByHairdresserId(Long id);

    void deleteAllByClientId(Long id);
}
