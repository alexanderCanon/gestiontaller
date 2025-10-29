package com.sistemaBD.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @Column(name = "plate", nullable = false, length = 10)
    private String plate;

    @Column(name = "brand", nullable = false, length = 30)
    private String brand;

    @Column(name = "model", nullable = false, length = 40)
    private String model;
}