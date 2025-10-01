package com.sistemaBD.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mecanicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic {

    @Id
    @Column(name = "mecanico_id", nullable = false, length = 20)
    private String mecanicoId;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;

    @Column(name = "telefono", nullable = false)
    private Integer telefono;

}
