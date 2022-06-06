package com.example.barbershopprogramming.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentDTO {

    private LocalDate day;

    private LocalTime startTime;

//    private LocalTime endTime;
}
