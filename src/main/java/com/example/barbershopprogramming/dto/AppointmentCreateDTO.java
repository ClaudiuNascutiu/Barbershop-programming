package com.example.barbershopprogramming.dto;

import com.example.barbershopprogramming.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentCreateDTO {

    private Long id;

    private LocalDate day;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;

    private Long hairdresserId;

    private Long clientId;
}
