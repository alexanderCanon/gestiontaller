package com.sistemaBD.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    @NotNull(message = "El numero es obligatorio")
    private int telefono;
    @NotNull(message = "La direccion es obligatoria")
    private String direccion;
}
