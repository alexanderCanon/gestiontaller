package com.sistemaBD.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int clienteId;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @Column(name = "direccion", nullable = false, length = 25)
    private String direccion;
}
