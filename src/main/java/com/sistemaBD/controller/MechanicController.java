package com.sistemaBD.controller;

import com.sistemaBD.dto.MechanicRequestDTO;
import com.sistemaBD.dto.MechanicResponseDTO;
import com.sistemaBD.service.IMechanicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mecanicos")
public class MechanicController {

    @Autowired
    private IMechanicService mechanicService;

    @PostMapping
    public ResponseEntity<MechanicResponseDTO> create(@Valid @RequestBody MechanicRequestDTO requestDTO) {
        MechanicResponseDTO newMechanic = mechanicService.createMechanic(requestDTO);
        return new ResponseEntity<>(newMechanic, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MechanicResponseDTO>> getAll() {
        return ResponseEntity.ok(mechanicService.getAllMechanics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MechanicResponseDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(mechanicService.getMechanicById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MechanicResponseDTO> update(@PathVariable String id, @Valid @RequestBody MechanicRequestDTO requestDTO) {
        MechanicResponseDTO updatedMechanic = mechanicService.updateMechanic(id, requestDTO);
        return ResponseEntity.ok(updatedMechanic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        mechanicService.deleteMechanic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<MechanicResponseDTO>> getByApellido(@PathVariable String apellido) {
        List<MechanicResponseDTO> mechanics = mechanicService.getMechanicsByApellido(apellido);
        return ResponseEntity.ok(mechanics);
    }
}