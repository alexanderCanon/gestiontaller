package com.sistemaBD.dto;


import lombok.Data;

@Data
public class CustomerRequestDTO {

    // Asumimos que necesitas validación, pero la omitimos por simplicidad de la estructura
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
}
