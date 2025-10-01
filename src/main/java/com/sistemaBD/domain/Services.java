package com.sistemaBD.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="servicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {

    @Id
    @Column(name = "servicio_id", nullable = false)
    private int servicioId;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "costo", nullable = false)
    private int costo;

}
