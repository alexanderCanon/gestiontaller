package com.sistemaBD.controller;

import com.sistemaBD.domain.Mechanic;
import com.sistemaBD.dto.MechanicResponseDTO;
import com.sistemaBD.service.IMechanicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mecanicos")
@RequiredArgsConstructor
public class MechanicController {

    private final IMechanicService mechanicService;

    @PostMapping
    public ResponseEntity<MechanicResponseDTO> createMechanic(@RequestBody Mechanic mechanic) {

        MechanicResponseDTO newMechanic = mechanicService.save(mechanic);
        return new ResponseEntity<>(newMechanic, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MechanicResponseDTO>> getAllMechanics() {
        List<MechanicResponseDTO> mechanics = mechanicService.findAll();
        return ResponseEntity.ok(mechanics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MechanicResponseDTO> getMechanicById(@PathVariable String id) {
        return mechanicService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<MechanicResponseDTO>> getMechanicsByApellido(@PathVariable String apellido) {
        List<MechanicResponseDTO> mechanics = mechanicService.findByApellido(apellido);
        if (mechanics.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mechanics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MechanicResponseDTO> updateMechanic(
            @PathVariable String id,
            @RequestBody Mechanic mechanicDetails) {

        try {
            MechanicResponseDTO updatedMechanic = mechanicService.update(id, mechanicDetails);
            return ResponseEntity.ok(updatedMechanic);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMechanic(@PathVariable String id) {
        mechanicService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}