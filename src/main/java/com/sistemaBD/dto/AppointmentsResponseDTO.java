package com.sistemaBD.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentsResponseDTO {
    // IDs de la clave compuesta de la Cita (si aplica)
    private LocalDate fecha;
    private LocalTime hora;

    // Objetos anidados DTOs (puedes crear DTOs simples para estas entidades)
    private CustomerResponseDTO cliente;
    private ServicioResponseDTO servicio;
    private MechanicResponseDTO mecanico;

    private String observaciones;
    private String detalleVehiculo; // Ejemplo: "Toyota Yaris (ABC-123)"
    private String detalleAceite;   // Ejemplo: "Aceite Sintetico 5W-30"
}
