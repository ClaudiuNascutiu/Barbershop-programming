package com.example.barbershopprogramming.service.implementation;

import com.example.barbershopprogramming.dto.AppointmentCreateDTO;
import com.example.barbershopprogramming.dto.AppointmentDTO;
import com.example.barbershopprogramming.entity.Appointment;
import com.example.barbershopprogramming.repository.AppointmentRepository;
import com.example.barbershopprogramming.service.AppointmentService;
import com.example.barbershopprogramming.service.mapper.AppointmentMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  AppointmentMapper mapper) {
        this.appointmentRepository = appointmentRepository;
        this.mapper = mapper;
    }
    @Override
    public AppointmentDTO addAppointment(AppointmentCreateDTO appointment) {
        Appointment toBeSaved = mapper.toEntity(appointment);
        Appointment saved = appointmentRepository.save(toBeSaved);
        return mapper.toDTO(saved);
    }
    @Override
    public AppointmentDTO updateAppointment(AppointmentCreateDTO appointment, Long id) {
        appointmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
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
        LocalTime timeToCheck = LocalTime.parse("09:20:00");
        for (int i = 0; i < 10; i++) {
            timeToCheck = timeToCheck.plusMinutes(40);
            LocalTime finalTimeToCheck = timeToCheck;
            if (appointments.stream().noneMatch(appointment -> appointment.getStartTime().equals(finalTimeToCheck))) {
                availableSlots.add(LocalTime.parse(timeToCheck.toString()));
            }
            checkHourForPause(availableSlots, finalTimeToCheck);
            checkTime(day, availableSlots, timeToCheck);
        }
        if(day.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            LocalTime sunday = LocalTime.parse("00:00:00");
            return Collections.singletonList(sunday);
        }else{
            return availableSlots;
        }
    }

    private void checkTime(LocalDate day, List<LocalTime> availableSlots, LocalTime timeToCheck) {
        LocalTime checkTime = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        if (timeToCheck.equals(checkTime) || timeToCheck.isBefore(checkTime) && day.equals(LocalDate.now())) {
            availableSlots.remove(LocalTime.parse(timeToCheck.toString()));
        }
    }

    private void checkHourForPause(List<LocalTime> availableSlots, LocalTime finalTimeToCheck) {
        LocalTime checkPause = LocalTime.parse("12:00:00");
        if (finalTimeToCheck.equals(checkPause)) {
            availableSlots.remove(LocalTime.parse(checkPause.toString()));
        }
    }




    @Override
    public List<AppointmentDTO> getAllAppointmentByClientId(Long id) {
        List<Appointment> appointments = appointmentRepository.findAllByClientId(id);

        return appointments.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAllAppointmentByHairdresserId(Long id) {
        List<Appointment> appointments = appointmentRepository.findAllByHairdresserId(id);

        return appointments.stream()
                .map(mapper::toDTOForHairdresser)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAllAppointmentsBeforeTheCurrentDateByClientId(Long id) {
        List<Appointment> appointments = appointmentRepository.findAllByClientId(id);
        List<Appointment> appointmentsBeforeTheCurrentDay = new ArrayList<>();

        for (Appointment appointment : appointments) {
            if (appointment.getDay().isBefore(LocalDate.now())){
                appointmentsBeforeTheCurrentDay.add(appointment);
            }
        }
        return appointmentsBeforeTheCurrentDay.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAllAppointmentsAfterTheCurrentDateByClientId(Long id) {
        List<Appointment> appointments = appointmentRepository.findAllByClientId(id);
        List<Appointment> appointmentsAfterTheCurrentDay = new ArrayList<>();

        for (Appointment appointment : appointments) {
            if (appointment.getDay().isAfter(LocalDate.now())){
                appointmentsAfterTheCurrentDay.add(appointment);
            }
        }
        return appointmentsAfterTheCurrentDay.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteAllAppointmentByClientId(Long clientId) {
        appointmentRepository.deleteAllByClientId(clientId);
    }

}
