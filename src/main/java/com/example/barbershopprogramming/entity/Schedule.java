package com.example.barbershopprogramming.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Schedule {

    private LocalTime startTime = LocalTime.parse("10:00");

    private LocalTime endTime = LocalTime.parse("17:00");
}
