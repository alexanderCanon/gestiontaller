package com.sistemaBD.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointments {

    // 1. Mapeo de la Clave Compuesta
    @EmbeddedId
    private AppointmentsId id;

    // 2. Campo 'fecha'
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha; // Se usa LocalDate para tipos DATE de SQL

    // 3. Relación Clave Foránea: Servicio (Parte de la clave compuesta)
    // @MapsId se usa para indicar que este campo usa el valor del campo 'servicioId' de AppointmentsId
    @ManyToOne
    @MapsId("servicioId")
    @JoinColumn(name = "servicio_id", insertable = false, updatable = false) // Columna en la tabla citas
    private Services servicio;

    // 4. Relación Clave Foránea: Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Customer cliente;

    // 5. Relación Clave Foránea: Vehiculo
    @ManyToOne
    @JoinColumn(name = "placa", nullable = false)
    private Vehicles vehiculo;

    // 6. Relación Clave Foránea: Mecanico
    @ManyToOne
    @JoinColumn(name = "mecanico_id", nullable = false)
    private Mechanic mecanico;

    // 7. Campo 'aceite'
    @Column(name = "aceite", nullable = false)
    private Boolean aceite; // Se usa Boolean para tipos BOOLEAN de SQL

}

