package com.sistemaBD.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "aceites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aceite_id", nullable = false)
    private Integer aceiteId;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "tipo", nullable = false, length = 25)
    private String tipo;

    @Column(name = "precio", nullable = false)
    private Integer precio;
}
