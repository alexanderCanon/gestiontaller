package com.sistemaBD.controller;

import com.sistemaBD.domain.Mechanic;
import com.sistemaBD.dto.MechanicResponseDTO;
import com.sistemaBD.service.IMechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mecanicos")
public class MechanicController {

    @Autowired // Inyección de dependencia por campo (Field Injection)
    private IMechanicService mechanicService;

    // Endpoint para CREAR un nuevo mecánico
    // POST http://localhost:8080/mecanicos
    @PostMapping
    public ResponseEntity<MechanicResponseDTO> createMechanic(@RequestBody Mechanic mechanic) {
        MechanicResponseDTO newMechanic = mechanicService.save(mechanic);
        return new ResponseEntity<>(newMechanic, HttpStatus.CREATED);
    }

    // Endpoint para OBTENER TODOS los mecánicos
    // GET http://localhost:8080/mecanicos
    @GetMapping
    public ResponseEntity<List<MechanicResponseDTO>> getAllMechanics() {
        return ResponseEntity.ok(mechanicService.findAll());
    }

    // Endpoint para OBTENER UN mecánico por ID
    // GET http://localhost:8080/mecanicos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MechanicResponseDTO> getMechanicById(@PathVariable String id) {
        // Usa Optional para obtener el mecánico, mapeando a OK o Not Found.
        Optional<MechanicResponseDTO> mechanic = mechanicService.findById(id);

        return mechanic
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para ACTUALIZAR un mecánico
    // PUT http://localhost:8080/mecanicos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<MechanicResponseDTO> updateMechanic(
            @PathVariable String id,
            @RequestBody Mechanic mechanicDetails) {

        // Se asume que el servicio maneja la excepción NotFound o retorna la entidad actualizada.
        MechanicResponseDTO updatedMechanic = mechanicService.update(id, mechanicDetails);
        return ResponseEntity.ok(updatedMechanic);
    }

    // Endpoint para ELIMINAR un mecánico
    // DELETE http://localhost:8080/mecanicos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMechanic(@PathVariable String id) {
        mechanicService.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna un código 204 No Content
    }

    // Endpoint para OBTENER mecánicos por apellido
    // GET http://localhost:8080/mecanicos/apellido/{apellido}
    @GetMapping("/apellido/{apellido}")
    public ResponseEntity<List<MechanicResponseDTO>> getMechanicsByApellido(@PathVariable String apellido) {
        List<MechanicResponseDTO> mechanics = mechanicService.findByApellido(apellido);

        if (mechanics.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mechanics);
    }
}
