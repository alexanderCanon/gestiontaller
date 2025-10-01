package com.sistemaBD.repository;

import com.sistemaBD.domain.Appointments;
import com.sistemaBD.domain.AppointmentsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointments, AppointmentsId> {

    // Método de ejemplo: Buscar Appointmentss por fecha
    List<Appointments> findByFecha(LocalDate fecha);

    // Método de ejemplo: Buscar Appointmentss por el ID del cliente (usando la relación)
    List<Appointments> findByCliente_ClienteId(Integer clienteId);

    // Método de ejemplo: Buscar Appointmentss que incluyen aceite
    List<Appointments> findByAceiteTrue();
}
