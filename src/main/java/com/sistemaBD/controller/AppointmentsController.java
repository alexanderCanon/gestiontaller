package com.sistemaBD.controller;

import com.sistemaBD.dto.AppointmentsRequestDTO;
import com.sistemaBD.dto.AppointmentsResponseDTO;
import com.sistemaBD.service.IAppointmentsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class AppointmentsController {

    @Autowired
    private IAppointmentsService appointmentsService;

    @GetMapping
    public ResponseEntity<List<AppointmentsResponseDTO>> getAll() {
        return ResponseEntity.ok(appointmentsService.getAllAppointments());
    }

    @GetMapping("/{citaId}/{servicioId}")
    public ResponseEntity<AppointmentsResponseDTO> getById(@PathVariable String citaId, @PathVariable Integer servicioId) {
        return ResponseEntity.ok(appointmentsService.getAppointmentById(citaId, servicioId));
    }

    @PostMapping
    public ResponseEntity<AppointmentsResponseDTO> create(@Valid @RequestBody AppointmentsRequestDTO requestDTO) {
        AppointmentsResponseDTO createdAppointment = appointmentsService.createAppointment(requestDTO);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/{citaId}/{servicioId}")
    public ResponseEntity<AppointmentsResponseDTO> update(@PathVariable String citaId, @PathVariable Integer servicioId, @Valid @RequestBody AppointmentsRequestDTO requestDTO) {
        AppointmentsResponseDTO updatedAppointment = appointmentsService.updateAppointment(citaId, servicioId, requestDTO);
        return ResponseEntity.ok(updatedAppointment);
    }

    @DeleteMapping("/{citaId}/{servicioId}")
    public ResponseEntity<Void> delete(@PathVariable String citaId, @PathVariable Integer servicioId) {
        appointmentsService.deleteAppointment(citaId, servicioId);
        return ResponseEntity.noContent().build();
    }
}
