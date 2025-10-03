package com.sistemaBD.dto;

import lombok.Data;

@Data
public class OilResponseDTO {

    private Integer aceiteId;
    private String nombre;
    private String tipo;
    private Integer precio;
}