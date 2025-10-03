package com.sistemaBD.controller;

import com.sistemaBD.dto.VehiclesRequestDTO;
import com.sistemaBD.dto.VehiclesResponseDTO;
import com.sistemaBD.service.VehiclesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles") // Define la URL base para todos los endpoints de este controlador
public class VehiclesController {

    private final VehiclesService vehiclesService;

    // Inyección de dependencias por constructor (principio SOLID)
    public VehiclesController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    /**
     * Endpoint para OBTENER todos los vehículos.
     * HTTP GET /api/v1/vehicles
     */
    @GetMapping
    public ResponseEntity<List<VehiclesResponseDTO>> getAllVehicles() {
        List<VehiclesResponseDTO> vehicles = vehiclesService.findAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    /**
     * Endpoint para OBTENER un vehículo por su placa.
     * HTTP GET /api/v1/vehicles/{placa}
     */
    @GetMapping("/{placa}")
    public ResponseEntity<VehiclesResponseDTO> getVehicleById(@PathVariable String placa) {
        VehiclesResponseDTO vehicle = vehiclesService.findById(placa);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    /**
     * Endpoint para CREAR un nuevo vehículo.
     * HTTP POST /api/v1/vehicles
     */
    @PostMapping
    public ResponseEntity<VehiclesResponseDTO> createVehicle(@Valid @RequestBody VehiclesRequestDTO requestDTO) {
        VehiclesResponseDTO newVehicle = vehiclesService.save(requestDTO);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    /**
     * Endpoint para ACTUALIZAR un vehículo existente.
     * HTTP PUT /api/v1/vehicles/{placa}
     */
    @PutMapping("/{placa}")
    public ResponseEntity<VehiclesResponseDTO> updateVehicle(@PathVariable String placa, @Valid @RequestBody VehiclesRequestDTO requestDTO) {
        VehiclesResponseDTO updatedVehicle = vehiclesService.update(placa, requestDTO);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }

    /**
     * Endpoint para ELIMINAR un vehículo.
     * HTTP DELETE /api/v1/vehicles/{placa}
     */
    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String placa) {
        vehiclesService.deleteById(placa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content es el estándar para deletes exitosos
    }
}