package com.sistemaBD.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentsRequestDTO {

    // IDs para las relaciones ManyToOne
    private Integer clienteId;
    private String vehiculoPlaca; // Asumiendo que Placa es el ID del Vehiculo
    private String mecanicoId;    // Asumiendo que Mecanico tiene un ID tipo String
    private Integer servicioId;

    // Campos propios de la Cita
    private LocalDate fecha;
    private LocalTime hora;
    private String observaciones;
    private Boolean incluyeAceite; // Si es True, necesita el aceiteId
    private Integer aceiteId;
}
