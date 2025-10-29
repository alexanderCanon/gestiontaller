package com.sistemaBD.service;

import com.sistemaBD.domain.Appointment;
import com.sistemaBD.domain.ServiceEntity;
import com.sistemaBD.domain.User;
import com.sistemaBD.domain.Vehicle;
import com.sistemaBD.dto.request.AppointmentRequest;
import com.sistemaBD.dto.response.AppointmentResponse;
import com.sistemaBD.repository.AppointmentsRepository;
import com.sistemaBD.repository.ServiceEntityRepository;
import com.sistemaBD.repository.UserRepository;
import com.sistemaBD.repository.VehicleRepository;
import com.sistemaBD.service.iservice.IAppointmentService;
import com.sistemaBD.service.mapper.AppointmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService {

    private final AppointmentsRepository appointmentsRepository;
    private final ServiceEntityRepository serviceRepository;
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public List<AppointmentResponse> findAll() {
        return appointmentsRepository.findAll().stream()
                .map(appointmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentResponse findById(Integer id) {
        return appointmentsRepository.findById(id)
                .map(appointmentMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public AppointmentResponse save(AppointmentRequest request) {
        ServiceEntity service = serviceRepository.findById(request.getServiceId()).orElseThrow(() -> new RuntimeException("Service not found"));
        Vehicle vehicle = vehicleRepository.findById(request.getPlate()).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        User user = userRepository.findById(request.getUserDpi()).orElseThrow(() -> new RuntimeException("User not found"));

        Appointment appointment = appointmentMapper.toEntity(request);
        appointment.setService(service);
        appointment.setVehicle(vehicle);
        appointment.setUser(user);

        return appointmentMapper.toResponse(appointmentsRepository.save(appointment));
    }

    @Override
    public AppointmentResponse update(Integer id, AppointmentRequest request) {
        Appointment appointmentToUpdate = appointmentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        ServiceEntity service = serviceRepository.findById(request.getServiceId()).orElseThrow(() -> new RuntimeException("Service not found"));
        Vehicle vehicle = vehicleRepository.findById(request.getPlate()).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        User user = userRepository.findById(request.getUserDpi()).orElseThrow(() -> new RuntimeException("User not found"));

        appointmentMapper.updateFromDto(request, appointmentToUpdate);
        appointmentToUpdate.setService(service);
        appointmentToUpdate.setVehicle(vehicle);
        appointmentToUpdate.setUser(user);

        return appointmentMapper.toResponse(appointmentsRepository.save(appointmentToUpdate));
    }

    @Override
    public void delete(Integer id) {
        appointmentsRepository.deleteById(id);
    }
}
