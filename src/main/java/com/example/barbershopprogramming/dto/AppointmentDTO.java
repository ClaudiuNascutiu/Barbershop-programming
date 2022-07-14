package com.example.barbershopprogramming.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentDTO {

    private Long id;

    private LocalDate day;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;

    private String hairdresserName;

    private String hairdresserLastName;

    private String hairdresserPhone;

    private String hairdresserEmail;

    private String clientName;

    private String clientLastName;

    private String clientPhone;

    private String clientEmail;

}
