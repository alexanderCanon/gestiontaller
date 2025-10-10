package com.sistemaBD.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentsResponseDTO {

    private String citaId;
    private LocalDate fecha;
    private Boolean incluyeAceite;

    // DTOs anidados para mostrar la información completa
    private CustomerResponseDTO cliente;
    private ServicesResponseDTO servicio;
    private MechanicResponseDTO mecanico;
    private VehiclesResponseDTO vehiculo;
}