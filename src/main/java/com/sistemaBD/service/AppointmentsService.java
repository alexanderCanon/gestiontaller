package com.sistemaBD.service;

import com.sistemaBD.domain.Appointments;
import com.sistemaBD.domain.AppointmentsId;
import com.sistemaBD.dto.AppointmentsRequestDTO;
import com.sistemaBD.dto.AppointmentsResponseDTO;
import com.sistemaBD.repository.AppointmentsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService implements IAppointmentsService {

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private AppointmentsMapper appointmentsMapper;

    @Override
    public List<AppointmentsResponseDTO> getAllAppointments() {
        return appointmentsMapper.toResponseDTOList(appointmentsRepository.findAll());
    }

    @Override
    public AppointmentsResponseDTO getAppointmentById(String citaId, Integer servicioId) {
        Appointments appointment = findAppointmentByIdOrThrow(citaId, servicioId);
        return appointmentsMapper.toResponseDTO(appointment);
    }

    @Override
    public AppointmentsResponseDTO createAppointment(AppointmentsRequestDTO requestDTO) {
        AppointmentsId id = new AppointmentsId(requestDTO.getCitaId(), requestDTO.getServicioId());
        if (appointmentsRepository.existsById(id)) {
            throw new IllegalArgumentException("Ya existe una cita con el ID de cita y servicio proporcionado.");
        }
        Appointments appointment = appointmentsMapper.toEntity(requestDTO);
        Appointments savedAppointment = appointmentsRepository.save(appointment);
        return appointmentsMapper.toResponseDTO(savedAppointment);
    }

    @Override
    public AppointmentsResponseDTO updateAppointment(String citaId, Integer servicioId, AppointmentsRequestDTO requestDTO) {
        Appointments existingAppointment = findAppointmentByIdOrThrow(citaId, servicioId);
        appointmentsMapper.updateEntityFromDto(requestDTO, existingAppointment);
        Appointments updatedAppointment = appointmentsRepository.save(existingAppointment);
        return appointmentsMapper.toResponseDTO(updatedAppointment);
    }

    @Override
    public void deleteAppointment(String citaId, Integer servicioId) {
        AppointmentsId id = new AppointmentsId(citaId, servicioId);
        if (!appointmentsRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar. Cita no encontrada.");
        }
        appointmentsRepository.deleteById(id);
    }

    private Appointments findAppointmentByIdOrThrow(String citaId, Integer servicioId) {
        AppointmentsId id = new AppointmentsId(citaId, servicioId);
        return appointmentsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cita no encontrada con ID: " + citaId + " y Servicio ID: " + servicioId));
    }
}
