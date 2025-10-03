package com.sistemaBD.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OilRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 25, message = "El nombre no puede exceder los 25 caracteres.")
    private String nombre;

    @NotBlank(message = "El tipo no puede estar vacío.")
    @Size(max = 25, message = "El tipo no puede exceder los 25 caracteres.")
    private String tipo;

    @NotNull(message = "El precio es obligatorio.")
    @Positive(message = "El precio debe ser un número positivo.")
    private Integer precio;
}