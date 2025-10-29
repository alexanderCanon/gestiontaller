package com.sistemaBD.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentRequest {
    private LocalDate date;
    private Integer serviceId;
    private String plate;
    private Boolean oil;
    private String userDpi;
}
