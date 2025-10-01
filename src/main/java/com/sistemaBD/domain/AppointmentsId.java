package com.sistemaBD.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentsId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cita_id", nullable = false, length = 10)
    private String citaId;

    @Column(name = "servicio_id", nullable = false)
    private Integer servicioId; // Mapeado a la columna 'servicio_id'
}
