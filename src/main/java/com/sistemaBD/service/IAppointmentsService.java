package com.sistemaBD.service;

import com.sistemaBD.dto.AppointmentsRequestDTO;
import com.sistemaBD.dto.AppointmentsResponseDTO;

import java.util.List;

public interface IAppointmentsService {

    List<AppointmentsResponseDTO> getAllAppointments();

    AppointmentsResponseDTO getAppointmentById(String citaId, Integer servicioId);

    AppointmentsResponseDTO createAppointment(AppointmentsRequestDTO requestDTO);

    AppointmentsResponseDTO updateAppointment(String citaId, Integer servicioId, AppointmentsRequestDTO requestDTO);

    void deleteAppointment(String citaId, Integer servicioId);
}
