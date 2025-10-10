package com.sistemaBD.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentsRequestDTO {

    @NotBlank(message = "El ID de la cita es obligatorio")
    private String citaId;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede ser en el pasado")
    private LocalDate fecha;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Integer clienteId;

    @NotBlank(message = "La placa del vehiculo es obligatoria")
    private String vehiculoPlaca;

    @NotBlank(message = "El ID del mecanico es obligatorio")
    private String mecanicoId;

    @NotNull(message = "El ID del servicio es obligatorio")
    private Integer servicioId;

    @NotNull(message = "Debe especificar si incluye aceite")
    private Boolean incluyeAceite;
}