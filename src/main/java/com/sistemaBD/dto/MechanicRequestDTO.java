package com.sistemaBD.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MechanicRequestDTO {

    @NotBlank(message = "El ID del mecanico es obligatorio")
    private String mecanicoId;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotNull(message = "El telefono es obligatorio")
    private Integer telefono;
}
