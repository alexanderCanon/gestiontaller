package com.sistemaBD.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private Integer clienteId;
    private String nombreCompleto; // Puedes combinar nombre y apellido aquí
    private int telefono;
    private String direccion;

}
