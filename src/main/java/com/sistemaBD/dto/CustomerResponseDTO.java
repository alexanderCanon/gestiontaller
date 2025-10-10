package com.sistemaBD.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private Integer clienteId;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;

}
