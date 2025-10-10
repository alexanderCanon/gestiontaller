package com.sistemaBD.controller;

import com.sistemaBD.dto.VehiclesRequestDTO;
import com.sistemaBD.dto.VehiclesResponseDTO;
import com.sistemaBD.service.VehiclesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiclesController {

    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping
    public ResponseEntity<List<VehiclesResponseDTO>> getAll() {
        return ResponseEntity.ok(vehiclesService.getAllVehicles());
    }

    @GetMapping("/{placa}")
    public ResponseEntity<VehiclesResponseDTO> getById(@PathVariable String placa) {
        return ResponseEntity.ok(vehiclesService.getVehicleById(placa));
    }

    @PostMapping
    public ResponseEntity<VehiclesResponseDTO> create(@Valid @RequestBody VehiclesRequestDTO requestDTO) {
        VehiclesResponseDTO newVehicle = vehiclesService.createVehicle(requestDTO);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @PutMapping("/{placa}")
    public ResponseEntity<VehiclesResponseDTO> update(@PathVariable String placa, @Valid @RequestBody VehiclesRequestDTO requestDTO) {
        VehiclesResponseDTO updatedVehicle = vehiclesService.updateVehicle(placa, requestDTO);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> delete(@PathVariable String placa) {
        vehiclesService.deleteVehicle(placa);
        return ResponseEntity.noContent().build();
    }
}
