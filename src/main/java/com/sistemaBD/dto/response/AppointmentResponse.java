package com.sistemaBD.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {
    private Integer appointmentId;
    private LocalDate date;
    private ServiceResponse service;
    private VehicleResponse vehicle;
    private Boolean oil;
    private UserResponse user;
}
