package com.sistemaBD.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemaBD.domain.Appointment;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Integer> {

    // Método de ejemplo: Buscar Appointmentss por fecha
    List<Appointment> findByDate(LocalDate date);

    // Método de ejemplo: Buscar Appointmentss por el ID del cliente (usando la relación)
    List<Appointment> findByUser_Dpi(String dpi);

    // Método de ejemplo: Buscar Appointments que incluyen aceite
    List<Appointment> findByOilTrue();
}