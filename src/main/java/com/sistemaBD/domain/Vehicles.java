package com.sistemaBD.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {
    @Id
    @Column(name = "placa", nullable = false, length = 10)
    private String placa;

    @Column(name = "marca", nullable = false, length = 10)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 10)
    private String modelo;
}

