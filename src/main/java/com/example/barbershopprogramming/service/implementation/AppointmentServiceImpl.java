package com.example.barbershopprogramming.service.implementation;

import com.example.barbershopprogramming.dto.AppointmentCreateDTO;
import com.example.barbershopprogramming.dto.AppointmentDTO;
import com.example.barbershopprogramming.entity.Appointment;
import com.example.barbershopprogramming.entity.Client;
import com.example.barbershopprogramming.entity.Hairdresser;
import com.example.barbershopprogramming.repository.AppointmentRepository;
import com.example.barbershopprogramming.repository.ClientRepository;
import com.example.barbershopprogramming.repository.HairdresserRepository;
import com.example.barbershopprogramming.service.AppointmentService;
import com.example.barbershopprogramming.service.mapper.AppointmentMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final HairdresserRepository hairdresserRepository;

    private final ClientRepository clientRepository;

    private Hairdresser hairdresser;

    private Client client;

    private final AppointmentMapper mapper;


    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  HairdresserRepository hairdresserRepository,
                                  ClientRepository clientRepository, AppointmentMapper mapper) {
        this.appointmentRepository = appointmentRepository;
        this.hairdresserRepository = hairdresserRepository;
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Override
    public AppointmentDTO addAppointment(AppointmentCreateDTO appointment, Long hairdresserId, Long clientId) {
        hairdresser = hairdresserRepository.findById(hairdresserId).orElseThrow(NoSuchElementException::new);
        client = clientRepository.findById(clientId).orElseThrow(NoSuchElementException::new);
        appointment.setHairdresserId(hairdresser.getId());
        appointment.setClientId(client.getId());
        Appointment toBeSaved = mapper.toEntity(appointment);
        Appointment saved = appointmentRepository.save(toBeSaved);
        return mapper.toDTO(saved);
    }

    @Override
    public AppointmentDTO updateAppointment(AppointmentCreateDTO appointment, Long id) {
        appointmentRepository.findById(id).orElseThrow(NoSuchElementException::new);

        appointment.setId(id);
        appointment.setHairdresserId(hairdresser.getId());
        appointment.setClientId(client.getId());


        Appointment toBeSaved = mapper.toEntity(appointment);
        Appointment saved = appointmentRepository.save(toBeSaved);

        return mapper.toDTO(saved);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<LocalTime> findEmptySlotsByHairdresserId(Long id, LocalDate day) {
        List<Appointment> appointments = appointmentRepository.findAllByHairdresserIdAndDay(id, day);
        List<LocalTime> availableSlots = new ArrayList<>();
        LocalTime timeToCheck = LocalTime.parse("09:00:00");

        for (int i = 0; i < 7; i++) {
            timeToCheck = timeToCheck.plusHours(1);
            LocalTime finalTimeToCheck = timeToCheck;
            if (appointments.stream().noneMatch(appointment -> appointment.getStartTime().equals(finalTimeToCheck))) {
                availableSlots.add(LocalTime.parse(timeToCheck.toString()));
            }
        }
        return availableSlots;
    }


}
