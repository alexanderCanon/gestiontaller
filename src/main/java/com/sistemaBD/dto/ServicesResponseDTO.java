package com.sistemaBD.dto;

import lombok.Data;

@Data
public class ServicesResponseDTO {

    private Integer servicioId;
    private String descripcion;
    private String tipo;
    private Integer costo;
}
