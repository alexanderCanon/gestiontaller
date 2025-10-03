package com.sistemaBD.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ServicesRequestDTO {

    @NotNull(message = "Debe ingresar el ID manual")
    @Min(value = 0, message = "El ID debe ser mayor a cero")
    private Integer servicioId;

    @NotBlank(message = "La descripción no puede estar vacía.")
    @Size(max = 255, message = "La descripción no puede exceder los 100 caracteres.")
    private String descripcion;

    @NotBlank(message = "El tipo de servicio no puede estar vacío.")
    private String tipo;

    @NotNull(message = "El costo no puede ser nulo.")
    @Min(value = 0, message = "El costo no puede ser negativo.")
    private Integer costo;
}
